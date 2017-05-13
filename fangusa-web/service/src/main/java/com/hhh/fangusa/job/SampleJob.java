package com.hhh.fangusa.job;

import com.hhh.fangusa.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: huodonghai
 * @Copyright (c) 2017 All Rights Reserved
 */
@Component("sampleJob")
public class SampleJob {

    static public String url = "https://www.zillow.com/homedetails/1940-N-Highland-Ave-APT-23-Los-Angeles-CA-90068/20803953_zpid/";

    @Resource(name = "streetSpider")
    private IJobExecute detailProcess;

    public void execute() {

        String res = null;
        try {
            res = HttpUtils.getHTML(url);
        } catch (IOException e) {
        }

        detailProcess.execute();

    }
}
