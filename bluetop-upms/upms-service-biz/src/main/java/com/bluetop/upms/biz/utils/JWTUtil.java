package com.bluetop.upms.biz.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bluetop.upms.biz.cons.Config;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * <JWT工具类>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:37 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
public final class JWTUtil {

    /**
     * 校验token是否正确
     *
     * @param token    密钥
     * @param username 用户名
     * @param secret   用户的密码
     * @return 是否正确
     */
    public static void verify(String token, String username, String secret) throws Exception {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim(Config.JWT_CLIENT_USERNAME, username)
                .withIssuer(Config.JWT_IUSER)
                .build();
        verifier.verify(token);
    }

    /**
     * 获得token中自定义用户信息
     *
     * @param token
     * @returntoken中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(Config.JWT_CLIENT_USERNAME).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取token中的项目key
     *
     * @param token
     * @return
     */
    public static String getApplicationKey(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(Config.JWT_APPLICATION_KEY).asString();
        } catch (JWTDecodeException e) {
            log.error("[JWTUtils] get application key failed. {}", ExceptionUtils.getRootCauseMessage(e));
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param username       用户名
     * @param secret         用户的密码
     * @param activeTime     有效时间,毫秒
     * @param applicationKey 项目key
     * @return 加密的token
     */
    public static String sign(String username, String secret, String applicationKey, long activeTime) throws UnsupportedEncodingException {
        long currentTimes = System.currentTimeMillis();
        Date signdate = new Date(currentTimes);
        Date expireTime = new Date(currentTimes + activeTime);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim(Config.JWT_CLIENT_USERNAME, username)
                .withClaim(Config.JWT_APPLICATION_KEY, applicationKey)
                .withIssuer(Config.JWT_IUSER)
                .withExpiresAt(expireTime)
                .withIssuedAt(signdate)
                .sign(algorithm);
    }
}
