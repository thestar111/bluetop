/**
 * 文 件 名:  UserServiceFacade
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.facade;

import com.bluetop.framework.core.cons.Result;
import com.bluetop.upms.api.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <用户服务接口API>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 21:29
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public interface UserServiceFacade {

    /**
     * 获取当前用户
     *
     * @return
     */
    @GetMapping(value = "/current")
    Result<UserVO> getCurrentUser();
}
