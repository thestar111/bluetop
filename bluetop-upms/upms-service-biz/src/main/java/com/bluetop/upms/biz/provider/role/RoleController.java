package com.bluetop.upms.biz.provider.role;

import cn.hutool.core.collection.CollectionUtil;
import com.bluetop.framework.core.cons.Result;
import com.bluetop.upms.api.dto.role.JudgeRoleParams;
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
    public Result<List<RoleVO>> listRole() {
        Result<List<RoleVO>> resultInfo = new Result<>();
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
        User user = userMapper.getUserByUserName(userName);
        List<Role> roles = roleMapper.getRolesByAppKey(applicationKey);
        if (CollectionUtil.isNotEmpty(roles)) {
            List<RoleVO> roleVOS = Lists.newArrayList();
            roles.stream().forEach(role -> {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(role, roleVO);
                roleVOS.add(roleVO);
            });
            resultInfo.setData(roleVOS);
        }
        return resultInfo;
    }

    /**
     * 判断当前用户是否拥有超级管理员角色
     *
     * @return
     */
    @GetMapping(value = "/judge/super")
    @ApiOperation(value = "判断当前用户是否拥有超级管理员角色")
    @RequiresAuthentication
    public Result<Boolean> judgeSuper() {
        Result<Boolean> resultInfo = new Result<>();
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
        User user = userMapper.getUserByUserName(userName);
        List<Role> roles = roleMapper.getRolesByAppKey(applicationKey);
        resultInfo.setData(roleService.hasRole(roles, Config.SUPER_ADMIN_ROLE));
        return resultInfo;
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
    public Result<JudgeRole> judgeRole(@RequestBody JudgeRoleParams judgeRoleParams) {
        Result<JudgeRole> result = new Result<>();
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
        User user = userMapper.getUserByUserName(userName);
        List<Role> roles = roleMapper.getRolesByAppKey(applicationKey);
        JudgeRole judgeRole = new JudgeRole();
        judgeRole.setJudgeRoleKey(roleKey);
        judgeRole.setOwn(roleService.hasRole(roles, roleKey));
        result.setData(judgeRole);
        return result;
    }
}
