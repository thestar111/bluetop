package com.bluetop.upms.biz.provider.user;

import com.bluetop.framework.core.cons.Result;
import com.bluetop.upms.api.vo.UserVO;
import com.bluetop.upms.biz.core.exception.AuthException;
import com.bluetop.upms.biz.database.entity.User;
import com.bluetop.upms.biz.database.mapper.UserMapper;
import com.bluetop.upms.biz.utils.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "基于Shiro用户服务")
@RequestMapping("/user")
public class UserController implements UserServiceFacade {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取当前用户
     *
     * @return
     */
    @GetMapping(value = "/current")
    @ApiOperation(value = "获取当前用户")
    @RequiresAuthentication
    public Result<UserVO> getCurrentUser() {
        Result<UserVO> result = new Result<>();
        String token = null;
        if (StringUtils.isBlank(token)) {
            throw new AuthException("Params invalid!", 504);
        }
        boolean isAllowed = SecurityUtils.getSubject().isAuthenticated();
        if (isAllowed) {
            String userName = JWTUtil.getUsername(token);
            User user = userMapper.getUserByUserName(userName);
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            result.setData(userVO);
        } else {
            throw new AuthException("Token invalid!", 119);
        }
        return result;
    }

}
