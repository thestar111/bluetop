package com.bluetop.upms.biz.provider.role;

import com.bluetop.upms.biz.database.entity.Role;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <角色服务>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/28 2:59 上午
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Service
public class RoleService {

    /**
     * 判断是否超级管理员,条件:是否拥有roleKey为admin的角色
     *
     * @param roles
     * @return
     */
    public boolean hasRole(List<Role> roles, String roleKey) {
        if (StringUtils.isNotBlank(roleKey) && Objects.nonNull(roles) && roles.size() > 0) {
            for (Role role : roles) {
                if (roleKey.equalsIgnoreCase(role.getRoleKey())) {
                    return true;
                }
            }
        }
        return false;
    }
}
