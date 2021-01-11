/**
 * 文 件 名:  OauthController
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:03
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.biz.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bluetop.upms.api.dto.UserInfo;
import com.bluetop.upms.api.entity.SysUser;
import com.bluetop.upms.api.vo.Token;
import com.bluetop.upms.biz.cons.CommonConstants;
import com.bluetop.upms.biz.service.SysUserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.SecurityConstants;

import java.util.*;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/10 21:03
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/oauth")
@Api(value = "menu", tags = "系统授权登录接口")
public class OauthController {

    private final SysUserService sysUserService;

    /**
     * 系统登录授权
     *
     * @return
     */
    @PostMapping("/token")
    public Token login() {
        SysUser user = sysUserService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, "admin"));
        UserInfo info = sysUserService.getUserInfo(user);
        Set<String> dbAuthsSet = new HashSet<>();
        if (ArrayUtil.isNotEmpty(info.getRoles())) {
            // 获取角色
            Arrays.stream(info.getRoles()).forEach(role -> dbAuthsSet.add("ROLE_" + role));
            // 获取资源
            dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));
        }
        SysUser user1 = info.getSysUser();
        Token token = new Token();
        token.setAccess_token(UUID.randomUUID().toString());
        token.setRefresh_token(token.getAccess_token());
        token.setActive(true);
        return token;
    }
}
