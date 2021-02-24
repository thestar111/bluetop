/**
 * 文 件 名:  PermissionType
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.biz.cons;

import lombok.Getter;

/**
 * <权限类型>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/2/24 21:29
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Getter
public enum PermissionType {

    SYSTEM(0), MENU(1), API(2);

    private int code;

    PermissionType(int code) {
        this.code = code;
    }
}
