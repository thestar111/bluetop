/**
 * 文 件 名:  UserVO
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 22:17
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private String company;
    private String email;
    private String secret;
    /**
     * 0：注销，1:激活 -4:删除
     */
    private Integer status;
}
