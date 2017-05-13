package com.hhh.fangusa.service.impl;

import com.hhh.fangusa.dao.ResourceMapper;
import com.hhh.fangusa.exception.ExceptionConst;
import com.hhh.fangusa.exception.UserVisiableException;
import com.hhh.fangusa.model.Resource;
import com.hhh.fangusa.model.search.ResourceSearch;
import com.hhh.fangusa.parser.NaviBaseParser;
import com.hhh.fangusa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @Author: huodonghai
 * @Copyright (c) 2017 All Rights Reserved
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper mapper;

    @Override
    public Resource saveOrUpdate(Resource item) {
        if (item.getId() == null) {
            item.setCreatedTime(new Date());
            mapper.insert(item);

            item.setNo(getNo(item.getId()));
            mapper.updateByPrimaryKey(item);
        } else {
            Resource _item = mapper.selectByPrimaryKey(item.getId());
            if (_item == null) {
                throw new UserVisiableException(ExceptionConst.PARAM_MISSING_EXCEPTION, "没有id为" + item.getId() + "的记录");
            }
            item.setCreatedTime(_item.getCreatedTime());
            mapper.updateByPrimaryKey(item);
        }

        return item;
    }

    private Long getNo(Long id) {
        return 100000000L + id;
    }

    @Override
    public Resource get(Long id) {
        Resource _item = mapper.selectByPrimaryKey(id);
        return _item;
    }

    @Override
    public Map<String, Object> gets(ResourceSearch search) {
        return null;
    }

    @Override
    public void delete(Long id) {

        mapper.deleteByPrimaryKey(id);
    }
}
