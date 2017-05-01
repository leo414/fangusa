package com.hhh.fangusa.service;

import com.hhh.fangusa.model.Resource;
import com.hhh.fangusa.model.search.ResourceSearch;

import java.util.Map;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public interface ResourceService {

    void saveOrUpdate(Resource item);

    Resource get(Long id);

    Map<String, Object> gets(ResourceSearch search);

    void delete(Long id);
}
