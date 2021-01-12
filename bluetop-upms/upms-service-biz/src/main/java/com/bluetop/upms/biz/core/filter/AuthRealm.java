package com.bluetop.upms.biz.core.filter;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bluetop.upms.biz.cons.Config;
import com.bluetop.upms.biz.core.token.Token;
import com.bluetop.upms.biz.database.entity.Application;
import com.bluetop.upms.biz.database.entity.Resource;
import com.bluetop.upms.biz.database.entity.Role;
import com.bluetop.upms.biz.database.entity.User;
import com.bluetop.upms.biz.database.mapper.ApplicationMapper;
import com.bluetop.upms.biz.database.mapper.ResourceMapper;
import com.bluetop.upms.biz.database.mapper.RoleMapper;
import com.bluetop.upms.biz.database.mapper.UserMapper;
import com.bluetop.upms.biz.provider.role.RoleService;
import com.bluetop.upms.biz.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * <用户授权Realm>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:40 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private RoleService roleService;

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof Token;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String token = principals.toString();
        String username = JWTUtil.getUsername(token);
        String applicationKey = JWTUtil.getApplicationKey(token);
        User user = userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getUsername, username));
        if (user == null) {
            throw new AuthenticationException("User doesn't exist!");
        }
        List<Role> roles = roleMapper.getRolesByUserAndAppKey(user.getId(), applicationKey);
        List<Resource> resources = null;
        Application application = applicationMapper.selectOne(Wrappers.<Application>query().lambda().eq(Application::getApplicationKey, applicationKey));
        if (roleService.hasRole(roles, Config.SUPER_ADMIN_ROLE)) {
            resources = resourceMapper.getResourcesByAppKey(applicationKey);
        } else {
            resources = resourceMapper.getResourcesByUserAndAppKey(user.getId(), applicationKey);
        }
        return buildSimpleAuthorizationInfo(roles, resources);
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        String applicationKey = JWTUtil.getApplicationKey(token);
        if (StringUtils.isBlank(username) || StringUtils.isBlank(applicationKey)) {
            throw new AuthenticationException("Token is invalid!");
        }
        User user = userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getUsername, username));
        if (Objects.isNull(user)) {
            throw new AuthenticationException("User doesn't exist!");
        }
        Application application = applicationMapper.selectOne(Wrappers.<Application>query().lambda().eq(Application::getApplicationKey, applicationKey));
        if (Objects.isNull(application)) {
            throw new AuthenticationException("Application " + applicationKey + " doesn't exist!");
        }
        try {
            JWTUtil.verify(token, username, user.getSecret());
        } catch (Exception e) {
            log.error("[AuthRealm] invoke doGetAuthenticationInfo occur an unknown error, {}", ExceptionUtils.getRootCauseMessage(e));
            throw new AuthenticationException("Token is invalid!");
        }
        return new SimpleAuthenticationInfo(token, token, "authRealm");
    }

    /**
     * 构建用户权限信息
     *
     * @param roles
     * @param resources
     * @return
     */
    private SimpleAuthorizationInfo buildSimpleAuthorizationInfo(List<Role> roles, List<Resource> resources) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 加载用户角色信息
        if (Objects.nonNull(roles) && roles.size() > 0) {
            Set<String> roleSets = new LinkedHashSet<>();
            for (Role role : roles) {
                roleSets.add(role.getRoleKey());
            }
            simpleAuthorizationInfo.addRoles(roleSets);
        }
        // 加载权限
        if (Objects.nonNull(resources) && resources.size() > 0) {
            Set<String> permissionSets = new LinkedHashSet<>();
            for (Resource resource : resources) {
                permissionSets.add(resource.getUrl());
            }
            simpleAuthorizationInfo.addStringPermissions(permissionSets);
        }
        return simpleAuthorizationInfo;
    }
}
