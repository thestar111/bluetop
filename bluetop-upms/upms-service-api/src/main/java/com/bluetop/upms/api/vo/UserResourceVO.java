/**
 * 文 件 名:  UserResourceVO
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:06
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <用户资源信息>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/2/23 22:06
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Data
public class UserResourceVO implements Serializable {

    /**
     * 用户信息
     */
    private UserVO userVO;

    /**
     * 系统信息
     */
    private List<ResourceVO> systems;

    /**
     * 菜单信息
     */
    private List<ResourceVO> menu;

    /**
     * 权限信息
     */
    private List<ResourceVO> permission;
}
