package com.bluetop.upms.biz.provider.role;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bluetop.framework.core.vo.R;
import com.bluetop.upms.api.dto.role.JudgeRoleParams;
import com.bluetop.upms.api.facade.RoleServiceFacade;
import com.bluetop.upms.api.vo.JudgeRole;
import com.bluetop.upms.api.vo.RoleVO;
import com.bluetop.upms.biz.cons.Config;
import com.bluetop.upms.biz.core.exception.AuthException;
import com.bluetop.upms.biz.database.entity.Role;
import com.bluetop.upms.biz.database.entity.User;
import com.bluetop.upms.biz.database.mapper.RoleMapper;
import com.bluetop.upms.biz.database.mapper.UserMapper;
import com.bluetop.upms.biz.utils.JWTUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <角色接口>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@RestController
@Api(tags = "UPMS角色服务")
@RequestMapping("/role")
public class RoleController implements RoleServiceFacade {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    /**
     * 获取当前用户拥有的角色
     *
     * @return
     */
    @GetMapping(value = "/list")
    @ApiOperation(value = "获取当前用户拥有的角色")
    @RequiresAuthentication
    public R<List<RoleVO>> listRole() {
        R<List<RoleVO>> result = new R<>();
        String token = null;
        if (StringUtils.isBlank(token)) {
            throw new AuthException("Params invalid!", 504);
        }
        boolean isAllowed = SecurityUtils.getSubject().isAuthenticated();
        if (isAllowed) {
            throw new AuthException("Token invalid!", 119);
        }
        String userName = JWTUtil.getUsername(token);
        String applicationKey = JWTUtil.getApplicationKey(token);
        User user = userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getUsername, userName));
        List<Role> roles = roleMapper.getRolesByUserAndAppKey(user.getId(), applicationKey);
        if (CollectionUtil.isNotEmpty(roles)) {
            List<RoleVO> roleVOS = Lists.newArrayList();
            roles.stream().forEach(role -> {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(role, roleVO);
                roleVOS.add(roleVO);
            });
            result.setData(roleVOS);
        }
        return result;
    }

    /**
     * 判断当前用户是否拥有超级管理员角色
     *
     * @return
     */
    @GetMapping(value = "/judge/super")
    @ApiOperation(value = "判断当前用户是否拥有超级管理员角色")
    @RequiresAuthentication
    public R<Boolean> judgeSuper() {
        R<Boolean> result = new R<>();
        String token = null;
        if (StringUtils.isBlank(token)) {
            throw new AuthException("Params invalid!", 504);
        }
        boolean isAllowed = SecurityUtils.getSubject().isAuthenticated();
        if (!isAllowed) {
            throw new AuthException("Token invalid!", 119);
        }
        String userName = JWTUtil.getUsername(token);
        String applicationKey = JWTUtil.getApplicationKey(token);
        User user = userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getUsername, userName));
        List<Role> roles = roleMapper.getRolesByUserAndAppKey(user.getId(), applicationKey);
        result.setData(roleService.hasRole(roles, Config.SUPER_ADMIN_ROLE));
        return result;
    }

    /**
     * 判断当前用户是否拥有某个角色
     *
     * @param judgeRoleParams
     * @return
     */
    @PostMapping(value = "/judge/role")
    @ApiOperation(value = "判断当前用户是否拥有某个角色")
    @RequiresAuthentication
    public R<JudgeRole> judgeRole(@RequestBody JudgeRoleParams judgeRoleParams) {
        R<JudgeRole> result = new R<>();
        String token = null;
        if (StringUtils.isBlank(token) || Objects.isNull(judgeRoleParams)
                || StringUtils.isBlank(judgeRoleParams.getRoleKey())) {
            throw new AuthException("Params invalid!", 504);
        }
        boolean isAllowed = SecurityUtils.getSubject().isAuthenticated();
        if (!isAllowed) {
            throw new AuthException("Token invalid!", 119);
        }
        String roleKey = judgeRoleParams.getRoleKey();
        String userName = JWTUtil.getUsername(token);
        String applicationKey = JWTUtil.getApplicationKey(token);
        User user = userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getUsername, userName));
        List<Role> roles = roleMapper.getRolesByUserAndAppKey(user.getId(), applicationKey);
        JudgeRole judgeRole = new JudgeRole();
        judgeRole.setJudgeRoleKey(roleKey);
        judgeRole.setOwn(roleService.hasRole(roles, roleKey));
        result.setData(judgeRole);
        return result;
    }
}
