package com.hhh.fangusa.parser;

import com.hhh.fangusa.BaseTest;
import com.hhh.fangusa.service.ResourceService;
import com.hhh.fangusa.spider.DetailSpider;
import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public class ResourceTest extends BaseTest {

    @Resource(name = "detailSpider")
    private DetailSpider ds;

    @Resource(name = "resourceService")
    private ResourceService service;

    @Resource(name = "resourceParser")
    private IParser<com.hhh.fangusa.model.Resource> parser;

    private Long insertOne() {
        File f = new File("/Users/huodonghai/workspace/outsource/fangusa/git/fangusa/fangusa-web/t");
        try {
            String text = FileUtils.readFileToString(f, "UTF-8");
            com.hhh.fangusa.model.Resource item = parser.parse(text);

            item = service.saveOrUpdate(item);

            return item.getId();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());

            return null;
        }
    }

    @Test
    public void test1() {
        File f = new File("/Users/huodonghai/workspace/outsource/fangusa/git/fangusa/fangusa-web/t");
        try {
            String text = FileUtils.readFileToString(f, "UTF-8");
            ds.setResponse(text);
            ds.execute();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Test
    public void test2() {
        Long id = insertOne();

        com.hhh.fangusa.model.Resource item = service.get(id);

        Assert.assertNotNull(item);
        Assert.assertEquals(id, item.getId());
        System.out.println(item);
    }
}
