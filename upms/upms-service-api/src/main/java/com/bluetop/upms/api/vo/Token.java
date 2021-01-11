/**
 * 文 件 名:  Token
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  20:46
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/10 20:46
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class Token implements Serializable {

    private String access_token;
    private boolean active;
    private long expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;
    private UserInfo user_info;

    @Data
    static class UserInfo {
        private Integer userId;
        private Integer deptId;
        private String userName;
        private List<Map> authorities;
    }
}
