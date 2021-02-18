package com.bluetop.token.api.facade;

import com.bluetop.token.api.vo.TokenVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <授权获取token服务>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/26 12:15 下午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@FeignClient(value = "", url = "")
public interface AuthorizeServiceFacade {

    /**
     * 获取Token
     *
     * @return
     */
    @PostMapping(path = "/oauth/token")
    TokenVO oauth();
}
