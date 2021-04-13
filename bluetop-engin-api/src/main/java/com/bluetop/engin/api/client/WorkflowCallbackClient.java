/**
 * 文 件 名:  WorkflowCallBackClient
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  0:36
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.client;

import com.bluetop.engin.api.client.request.CallbackRequest;
import com.bluetop.engin.api.config.Api;
import feign.Headers;
import feign.RequestLine;

import java.util.Map;

/**
 * <回调接口>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/14 0:36
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Api(url = "http://com-service-dev.axhome.com.cn")
public interface WorkflowCallbackClient {

    /**
     * 请求回调
     *
     * @param request
     * @return
     */
    @RequestLine("POST /api/workflow/callback")
    @Headers({"Content-Type: application/json"})
    Map<String, Object> callback(CallbackRequest request);
}
