package com.example.sys.controller;

import com.example.sys.common.ResultObj;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sys.common.DataGridView;
import com.example.sys.entity.LogInfo;
import com.example.sys.service.LogInfoService;
import com.example.sys.vo.LoginfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuanzhikong
 * @since 2021-12-26
 */
@RestController
@RequestMapping("/loginfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;

    /**
     * 全查询
     */
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(LoginfoVo loginfoVo) {

        QueryWrapper<LogInfo> wrapper = new QueryWrapper<>();
        IPage<LogInfo> page = new Page<>(loginfoVo.getPage(), loginfoVo.getLimit());
        logInfoService.page(page, wrapper);
        wrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginname()), "loginname", loginfoVo.getLoginname());
        wrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginip()), "loginip", loginfoVo.getLoginip());
        wrapper.ge(loginfoVo.getStartTime() != null, "logintime", loginfoVo.getStartTime());
        wrapper.le(loginfoVo.getEndTime() != null, "logintime", loginfoVo.getEndTime());
        wrapper.orderByDesc("logintime");
        this.logInfoService.page(page, wrapper);
        /**
         * Total():数据总数 Records:相当于将集合数据放入其中，作为集合数据装载容器
         * 至于最后的page.getRecords()就是获取对应的数据。当然如果你要获取当前页或者数据总数可以对象.方法
         * 例如:
         * page.getTotal();
         */
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * 删除
     */
    @RequestMapping("deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id) {
        try {
            this.logInfoService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     */
    @RequestMapping("batchDeleteLoginfo")
    public ResultObj batchDeleteLoginfo(LoginfoVo loginfoVo) {
        try {
            Collection<Serializable> idList=new ArrayList<Serializable>();
            for (Integer id : loginfoVo.getIds()) {
                idList.add(id);
            }
            this.logInfoService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

