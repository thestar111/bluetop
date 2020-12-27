/**
 * 文 件 名:  RoleServiceFacade
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.api.facade;

import com.bluetop.framework.core.cons.Result;
import com.bluetop.upms.api.dto.role.JudgeRoleParams;
import com.bluetop.upms.api.vo.JudgeRole;
import com.bluetop.upms.api.vo.RoleVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <角色服务接口API>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/27 21:29
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public interface RoleServiceFacade {

    /**
     * 获取当前用户拥有的角色
     *
     * @return
     */
    @GetMapping(value = "/upms-service/api/list")
    Result<List<RoleVO>> listRole();

    /**
     * 判断当前用户是否拥有超级管理员角色
     *
     * @return
     */
    @GetMapping(value = "/upms-service/api/judge/super")
    Result<Boolean> judgeSuper();

    /**
     * 判断当前用户是否拥有某个角色
     *
     * @param judgeRoleParams
     * @return
     */
    @PostMapping(value = "/upms-service/api/judge/role")
    Result<JudgeRole> judgeRole(@RequestBody JudgeRoleParams judgeRoleParams);
}
