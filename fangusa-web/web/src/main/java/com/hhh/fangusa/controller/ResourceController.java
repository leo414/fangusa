package com.hhh.fangusa.controller;

import com.hhh.fangusa.exception.ExceptionConst;
import com.hhh.fangusa.exception.UserVisiableException;
import com.hhh.fangusa.model.JSONResult;
import com.hhh.fangusa.model.Resource;
import com.hhh.fangusa.model.ResultStatus;
import com.hhh.fangusa.model.search.ResourceSearch;
import com.hhh.fangusa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: huodonghai
 * @Copyright (c) 2017 All Rights Reserved
 */
public class ResourceController {

    @Autowired
    private ResourceService biz;

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public JSONResult save(Resource item) {
        biz.saveOrUpdate(item);

        return new JSONResult(ResultStatus.OK, "保存成功", null);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ResponseBody
    public JSONResult delete(Long id) {
        if (id == null) {
            throw new UserVisiableException(ExceptionConst.DATA_PERMISSION_EXCEPTION, "id不能为空");
        }

        biz.delete(id);

        return new JSONResult(ResultStatus.OK, "删除成功", null);
    }


    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JSONResult list(ResourceSearch search) {
        Map<String, Object> map = biz.gets(search);

        if (map == null) {
            return new JSONResult<>(0, "暂无数据", null);
        } else {
            return new JSONResult<>(map);
        }
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JSONResult get(Long id) {
        if (id == null) {
            throw new UserVisiableException(ExceptionConst.DATA_PERMISSION_EXCEPTION, "id不能为空");
        }

        Resource item = biz.get(id);

        if (item == null) {
            return new JSONResult<>(0, "暂无数据", null);
        } else {
            return new JSONResult<>(item);
        }
    }

}
