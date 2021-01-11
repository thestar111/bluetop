/**
 * 文 件 名:  AdminController
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.upms.biz.controller;

import com.bluetop.upms.api.dto.MenuTree;
import com.bluetop.upms.api.entity.SysUser;
import com.bluetop.upms.api.vo.MenuVO;
import com.bluetop.upms.api.vo.UserVO;
import com.bluetop.upms.biz.service.SysMenuService;
import com.bluetop.upms.biz.service.SysUserRoleService;
import com.bluetop.upms.biz.service.SysUserService;
import com.bluetop.upms.biz.utils.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/1/10 21:23
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final SysUserService sysUserService;

    private final SysMenuService sysMenuService;

    @GetMapping("/user/info")
    public R<UserVO> info() {
        UserVO userVO = sysUserService.getUserVoById(1);
        return R.ok(userVO);
    }

    @GetMapping("/menu")
    public R<List<MenuTree>> info(@RequestParam("parentId") Integer parentId) {
        List<MenuTree> menuTree = sysMenuService.treeMenu(false, 1);
        return R.ok(menuTree);
    }
}
