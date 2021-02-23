/**
 * 文 件 名:  AuthFacade
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.facade;

import com.bluetop.framework.core.vo.R;
import com.bluetop.upms.api.dto.auth.AuthTokenParams;
import com.bluetop.upms.api.dto.auth.JudgePerMissionParams;
import com.bluetop.upms.api.vo.ResourceVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * <授权服务接口API>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 21:28
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public interface AuthServiceFacade {

    /**
     * 获取Token
     *
     * @param authTokenParms
     * @return
     */
    @PostMapping(value = "/upms-service/api/token")
    R<String> getToken(@RequestBody AuthTokenParams authTokenParms);

    /**
     * 判断是否有权限
     *
     * @param judgePerMissionparams
     * @return
     */
    @PostMapping(value = "/upms-service/api/judge/permission")
    R<Boolean> judgePermission(@RequestBody JudgePerMissionParams judgePerMissionparams);

    /**
     * 获取用户权限
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/upms-service/api/list/permission")
    R<List<ResourceVO>> listPermission(@RequestHeader("Authorization") String token);

    /**
     * 未授权
     *
     * @return
     */
    @GetMapping(value = "/upms-service/api/401")
    R<String> unauthorized();
}
