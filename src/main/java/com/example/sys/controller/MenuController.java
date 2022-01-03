package com.example.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sys.common.*;
import com.example.sys.entity.Permission;
import com.example.sys.entity.User;
import com.example.sys.service.PermissionService;
import com.example.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *菜单前端控制器
 */
@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private PermissionService permissionService;

    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){
        //查询所有的参数
        QueryWrapper<Permission> wrapper = new QueryWrapper();
        //设置只能查菜单
        wrapper.eq("type", Constast.TYPE_MENU);
        wrapper.eq("available",Constast.AVAILABLE_TRUE);
        List<Permission> list = null;

        User user = (User) WebUtils.getSession().getAttribute("user");
        if(user.getType()==Constast.USER_TYPE_SUPER){
            //超级管理员拥有所有的权限
            list = permissionService.list(wrapper);
        }else {
            //普通用户 根据用户ID+角色+权限去查询
            list = permissionService.list(wrapper);
        }
        List<TreeNode> treeNodes=new ArrayList<>();
        for (Permission p : list) {
            Integer id=p.getId();
            Integer pid=p.getPid();
            String title=p.getTitle();
            String icon=p.getIcon();
            String href=p.getHref();
            Boolean spread=p.getOpen()==Constast.OPEN_TRUE?true:false;
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread));
        }
        //构造层级关系
        List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes, 1);
        return new DataGridView(list2);

    }

}
