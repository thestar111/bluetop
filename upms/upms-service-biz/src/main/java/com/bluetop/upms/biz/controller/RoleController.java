/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bluetop.upms.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bluetop.upms.api.entity.SysRole;
import com.bluetop.upms.api.vo.RoleVo;
import com.bluetop.upms.biz.service.SysRoleMenuService;
import com.bluetop.upms.biz.service.SysRoleService;
import com.bluetop.upms.biz.utils.R;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Api(value = "role", tags = "角色管理模块")
public class RoleController {

    private final SysRoleService sysRoleService;

    private final SysRoleMenuService sysRoleMenuService;

    /**
     * 通过ID查询角色信息
     *
     * @param id ID
     * @return 角色信息
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return R.ok(sysRoleService.getById(id));
    }

    /**
     * 添加角色
     *
     * @param sysRole 角色信息
     * @return success、false
     */
    @PostMapping
    public R save(@Valid @RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.save(sysRole));
    }

    /**
     * 修改角色
     *
     * @param sysRole 角色信息
     * @return success/false
     */
    @PutMapping
    public R update(@Valid @RequestBody SysRole sysRole) {
        return R.ok(sysRoleService.updateById(sysRole));
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return R.ok(sysRoleService.removeRoleById(id));
    }

    /**
     * 获取角色列表
     *
     * @return 角色列表
     */
    @GetMapping("/list")
    public R listRoles() {
        return R.ok(sysRoleService.list(Wrappers.emptyWrapper()));
    }

    /**
     * 分页查询角色信息
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public R getRolePage(Page page) {
        return R.ok(sysRoleService.page(page, Wrappers.emptyWrapper()));
    }

    /**
     * 更新角色菜单
     *
     * @param roleVo 角色对象
     * @return success、false
     */
    @PutMapping("/menu")
    public R saveRoleMenus(@RequestBody RoleVo roleVo) {
        SysRole sysRole = sysRoleService.getById(roleVo.getRoleId());
        return R.ok(sysRoleMenuService.saveRoleMenus(sysRole.getRoleCode(), roleVo.getRoleId(), roleVo.getMenuIds()));
    }
}
