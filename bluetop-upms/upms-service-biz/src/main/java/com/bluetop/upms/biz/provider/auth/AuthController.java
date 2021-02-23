package com.bluetop.upms.biz.provider.auth;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bluetop.framework.core.cons.Constans;
import com.bluetop.framework.core.utils.JWTUtils;
import com.bluetop.framework.core.vo.R;
import com.bluetop.upms.api.dto.auth.AuthTokenParams;
import com.bluetop.upms.api.dto.auth.JudgePerMissionParams;
import com.bluetop.upms.api.facade.AuthServiceFacade;
import com.bluetop.upms.api.vo.ResourceVO;
import com.bluetop.upms.biz.core.exception.AuthException;
import com.bluetop.upms.biz.database.entity.Application;
import com.bluetop.upms.biz.database.entity.Resource;
import com.bluetop.upms.biz.database.entity.User;
import com.bluetop.upms.biz.database.mapper.ApplicationMapper;
import com.bluetop.upms.biz.database.mapper.ResourceMapper;
import com.bluetop.upms.biz.database.mapper.UserMapper;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
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

/**
 * <授权服务>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 4:12 上午ø
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@RestController
@Api(tags = "UPMS鉴权服务")
public class AuthController implements AuthServiceFacade {

    @Value("${jwt.token.active.time:300000}")
    private long activeTime = 5 * 60 * 1000;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ApplicationMapper applicationMapper;

    /**
     * 获取用户token
     *
     * @param authTokenParms
     * @return
     */
    @PostMapping(value = "/token")
    @ApiOperation(value = "获取token")
    public R<String> getToken(@RequestBody AuthTokenParams authTokenParms) {
        if (Objects.isNull(authTokenParms)
                || StringUtils.isBlank(authTokenParms.getKey())
                || StringUtils.isBlank(authTokenParms.getName())
                || StringUtils.isBlank(authTokenParms.getPassword())) {
            log.error("[{}] request params invalid. params : {}", getClass().getSimpleName(), authTokenParms);
            throw new AuthException("Params invalid!", 504);
        }
        R<String> R = new R<>();
        Wrapper condition = Wrappers.<User>query().lambda().eq(User::getUsername, authTokenParms.getName()).eq(User::getStatus, 1);
        User user = userMapper.selectOne(condition);
        if (Objects.isNull(user)) {
            log.error("[{}] User doesn't existed! userName : {}", getClass().getSimpleName(), authTokenParms.getName());
            throw new AuthException("User doesn't existed!", 101);
        }
        Application application = applicationMapper.selectOne(Wrappers.<Application>query().lambda().eq(Application::getApplicationKey, authTokenParms.getKey()));
        if (Objects.isNull(application)) {
            log.error("[{}] User doesn't existed! applicationKey : {}", getClass().getSimpleName(), authTokenParms.getKey());
            throw new AuthException("Application " + authTokenParms.getKey() + " doesn't exist!", 120);
        }
        if (Objects.equals(authTokenParms.getPassword(), user.getPassword())) {
            try {
                R.setData(JWTUtils.sign(user.getUsername(), user.getSecret(), authTokenParms.getKey(), activeTime));
            } catch (UnsupportedEncodingException e) {
                log.error("[{}] Method getToken occur an UnsupportedEncodingException, error : {}", getClass().getSimpleName(), ExceptionUtils.getRootCauseMessage(e));
                throw new AuthException("Params invalid!", 504);
            }
        } else {
            throw new AuthException("Password error!", 114);
        }
        return R;
    }

    /**
     * 判断当前用户是否有权限
     *
     * @param judgePerMissionParams
     * @return
     */
    @PostMapping(value = "/judge/permission")
    @ApiOperation(value = "判断当前用户是否有权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constans.JWT_CUSTOMER_TOKEN_NAME, value = "认证token", required = true, dataType = "string", paramType = "header")
    })
    @RequiresAuthentication
    public R<Boolean> judgePermission(@RequestBody JudgePerMissionParams judgePerMissionParams) {
        if (Objects.isNull(judgePerMissionParams) || StringUtils.isBlank(judgePerMissionParams.getUrlAddress())) {
            log.error("[{}] request params invalid. params : {}", getClass().getSimpleName(), judgePerMissionParams);
            throw new AuthException("Params invalid!", 504);
        }
        R<Boolean> result = new R<>();
        boolean isAllowed = SecurityUtils.getSubject().isPermitted(judgePerMissionParams.getUrlAddress());
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
            @ApiImplicitParam(name = Constans.JWT_CUSTOMER_TOKEN_NAME, value = "认证token", required = true, dataType = "string", paramType = "header")
    })
    @RequiresAuthentication
    public R<List<ResourceVO>> listPermission(@RequestHeader("Authorization") String token) {
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            log.error("[{}] request params invalid. params : {}", getClass().getSimpleName(), token);
            throw new AuthException("Params invalid!", 504);
        }
        R<List<ResourceVO>> result = new R<>();
        String applicationKey = JWTUtils.getApplicationKey(token);
        String username = JWTUtils.getUsername(token);
        Wrapper condition = Wrappers.<User>query().lambda().eq(User::getUsername, username);
        User user = userMapper.selectOne(condition);
        List<Resource> resourceList = null;
        Application application = applicationMapper.selectOne(Wrappers.<Application>query().lambda().eq(Application::getApplicationKey, applicationKey));
        if (SecurityUtils.getSubject().hasRole(Constans.SUPER_ADMIN_ROLE)) {
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
            result.setData(resourceVOS);
        }
        return result;
    }

    /**
     * 没有权限
     *
     * @return
     */
    @GetMapping(value = "/401")
    @ApiIgnore
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public R<String> unauthorized() {
        R<String> R = new R<>();
        R.setCode(119);
        return R;
    }

}
