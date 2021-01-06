package com.bluetop.upms.biz.provider.auth;

import cn.hutool.core.collection.CollectionUtil;
import com.bluetop.framework.core.cons.Result;
import com.bluetop.upms.api.dto.auth.AuthTokenParams;
import com.bluetop.upms.api.dto.auth.JudgePerMissionparams;
import com.bluetop.upms.api.facade.AuthServiceFacade;
import com.bluetop.upms.api.vo.ResourceVO;
import com.bluetop.upms.biz.cons.Config;
import com.bluetop.upms.biz.core.exception.AuthException;
import com.bluetop.upms.biz.database.entity.Application;
import com.bluetop.upms.biz.database.entity.Resource;
import com.bluetop.upms.biz.database.entity.User;
import com.bluetop.upms.biz.database.mapper.ApplicationMapper;
import com.bluetop.upms.biz.database.mapper.ResourceMapper;
import com.bluetop.upms.biz.database.mapper.UserMapper;
import com.bluetop.upms.biz.utils.JWTUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;


@Slf4j
@RestController
@Api(tags = "UPMS鉴权服务")
public class AuthController implements AuthServiceFacade {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Value("${jwt.token.active.time:300000}")
    private long activeTime = 5 * 60 * 1000;

    /**
     * 获取用户token
     *
     * @param authTokenParms
     * @return
     */
    @PostMapping(value = "/token")
    @ApiOperation(value = "获取token")
    public Result<String> getToken(@RequestBody AuthTokenParams authTokenParms) {
        Result<String> result = new Result<>();
        if (Objects.nonNull(authTokenParms) && StringUtils.isNoneBlank(authTokenParms.getApplicationKey())
                && StringUtils.isNoneBlank(authTokenParms.getUserName())
                && StringUtils.isNoneBlank(authTokenParms.getPassword())) {
            User user = userMapper.getUserByUserName(authTokenParms.getUserName());
            if (Objects.isNull(user)) {
                throw new AuthException("User doesn't existed!", 101);
            }
            Application application = applicationMapper.getApplicationByAppkey(authTokenParms.getApplicationKey());
            if (Objects.isNull(application)) {
                throw new AuthException("Application " + authTokenParms.getApplicationKey() + " doesn't exist!", 120);
            }
            if (authTokenParms.getPassword().equals(user.getPassword())) {
                try {
                    result.setData(JWTUtil.sign(user.getUsername(), user.getSecret(), authTokenParms.getApplicationKey(), activeTime));
                } catch (UnsupportedEncodingException e) {
                    log.error("Method getToken occur an UnsupportedEncodingException!", e);
                    throw new AuthException("Params invalid!", 504);
                }
            } else {
                throw new AuthException("Password error!", 114);
            }

        } else {
            throw new AuthException("Params invalid!", 504);
        }
        return result;
    }

    /**
     * 判断当前用户是否有权限
     *
     * @param judgePerMissionparams
     * @return
     */
    @PostMapping(value = "/judge/permission")
    @ApiOperation(value = "判断当前用户是否有权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Config.JWT_CUSTOMER_TOKEN_NAME, value = "认证token", required = true, dataType = "string", paramType = "header")
    })
    @RequiresAuthentication
    public Result<Boolean> judgePermission(@RequestBody JudgePerMissionparams judgePerMissionparams) {
        if (Objects.isNull(judgePerMissionparams) || StringUtils.isBlank(judgePerMissionparams.getUrlAddress())) {
            throw new AuthException("Params invalid!", 504);
        }
        Result<Boolean> result = new Result<>();
        boolean isAllowed = SecurityUtils.getSubject().isPermitted(judgePerMissionparams.getUrlAddress());
        result.setData(isAllowed);
        return result;
    }

    /**
     * 获取权限列表
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/list/permission")
    @ApiOperation(value = "获取权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Config.JWT_CUSTOMER_TOKEN_NAME, value = "认证token", required = true, dataType = "string", paramType = "header")
    })
    @RequiresAuthentication
    public Result<List<ResourceVO>> listPermission(@RequestHeader("Authorization") String token) {
        Result<List<ResourceVO>> Result = new Result<>();
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            throw new AuthException("Params invalid!", 504);
        }
        String applicationKey = JWTUtil.getApplicationKey(token);
        String username = JWTUtil.getUsername(token);
        User user = userMapper.getUserByUserName(username);
        List<Resource> resourceList = null;
        if (SecurityUtils.getSubject().hasRole(Config.SUPER_ADMIN_ROLE)) {
            resourceList = resourceMapper.getResourcesByAppKey(applicationKey);
        } else {
            resourceList = resourceMapper.getResourcesByUserAndAppKey(user.getId(), applicationKey);
        }
        if (CollectionUtil.isNotEmpty(resourceList)) {
            List<ResourceVO> resourceVOS = Lists.newArrayListWithCapacity(resourceList.size());
            resourceList.stream().forEach(resource -> {
                ResourceVO resourceVO = new ResourceVO();
                BeanUtils.copyProperties(resource, resourceVO);
                resourceVOS.add(resourceVO);
            });
            Result.setData(resourceVOS);
        }
        return Result;
    }

    /**
     * 没有权限
     *
     * @return
     */
    @GetMapping(value = "/401")
    @ApiIgnore
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result<String> unauthorized() {
        Result<String> Result = new Result<>();
        Result.setCode(119);
        return Result;
    }

}
