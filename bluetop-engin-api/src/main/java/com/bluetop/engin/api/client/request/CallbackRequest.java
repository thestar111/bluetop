/**
 * 文 件 名:  CallbackRequest
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  0:39
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.client.request;

import cn.hutool.crypto.digest.MD5;
import com.google.common.collect.Maps;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/14 0:39
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class CallbackRequest implements Serializable {

    private Integer workflow_id;

    private String sign;

    private String timestamp;

    private Integer flow_record_id;

    /** 审批状态 0:通过，1:拒绝 */
    private Integer approve_status;

    private String flow_form;

    /**
     * 构造签名
     *
     * @param key
     * @return
     */
    public void buildSign(String key) {
        MD5 md5 = new MD5();
        Map<String, Object> obj = Maps.newHashMap();
        obj.put("flow_record_id", this.getFlow_record_id());
        obj.put("timestamp", this.getTimestamp());
        String text = obj.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
        this.setSign(md5.digestHex(text + "&key=" + key).substring(3, 27).toUpperCase());
    }

    public static void main(String[] args) {
        CallbackRequest request = new CallbackRequest();
        request.setFlow_record_id(100002);
        request.setTimestamp("10999999999");
        request.setApprove_status(1);
        request.buildSign("c7bccb45453a9d22");
        System.out.println(request);
    }
}
