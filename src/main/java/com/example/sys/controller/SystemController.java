package com.example.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SystemController {

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){

        return "system/index/login";
    }

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping("index")
    public String index(){

        return "system/index/index";
    }
    /**
     * 跳转到工作台
     */
    @RequestMapping("toDeskManager")
    public String toDeskManager(){

        return "system/index/toDeskManager";
    }

    /**
     * 跳转到日志管理
     * @return
     */
    @RequestMapping("toLoginfoManager")
    public String toLoginfoManager(){

        return "system/logInfo/loginfoManager";
    }

    /**
     * 跳转到公告管理
     *
     */
    @RequestMapping("toNoticeManager")
    public String toNoticeManager() {

        return "system/notice/noticeManager";
    }
    /**
     * 跳转到部门管理
     *
     */
    @RequestMapping("toDeptManager")
    public String toDeptManager() {
        return "system/dept/deptManager";
    }

    /**
     * 跳转到部门管理-left
     *
     */
    @RequestMapping("toDeptLeft")
    public String toDeptLeft() {
        return "system/dept/deptLeft";
    }


    /**
     * 跳转到部门管理--right
     *
     */
    @RequestMapping("toDeptRight")
    public String toDeptRight() {
        return "system/dept/deptRight";
    }
}
