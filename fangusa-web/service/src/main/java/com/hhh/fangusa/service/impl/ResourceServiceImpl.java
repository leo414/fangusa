package com.hhh.fangusa.service.impl;

import com.hhh.fangusa.dao.ResourceMapper;
import com.hhh.fangusa.model.Resource;
import com.hhh.fangusa.model.search.ResourceSearch;
import com.hhh.fangusa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: huodonghai
 * @Copyright (c) 2017 All Rights Reserved
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper mapper;

    @Override
    public void saveOrUpdate(Resource item) {

    }

    @Override
    public Resource get(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> gets(ResourceSearch search) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
