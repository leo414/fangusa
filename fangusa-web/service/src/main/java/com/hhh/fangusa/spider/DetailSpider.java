package com.hhh.fangusa.spider;

import com.hhh.fangusa.model.Resource;
import com.hhh.fangusa.parser.ResourceParser;
import com.hhh.fangusa.service.ResourceService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
@Component("detailSpider")
public class DetailSpider {
    private static Logger logger = LogManager.getLogger(DetailSpider.class);

    @javax.annotation.Resource(name = "resourceParser")
    private ResourceParser parser;
    @javax.annotation.Resource(name = "resourceService")
    private ResourceService service;

    private String response;

    public void setResponse(String response) {
        this.response = response;
    }

    public void execute() {

        if (StringUtils.isEmpty(response)) {
            logger.info("context is empty");
            return;
        }

        Resource item = parser.parse(response);

        service.saveOrUpdate(item);
    }


}
