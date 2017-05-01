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
public class StreetJob {

    static public final String naviBase = "https://www.zillow.com/browse/";
    static public final String la = "ca/los-angeles-county/";
    static public final String zip = "90895/";
    static public final String street = "Linden Ave/";

    @Resource(name = "streetProcess")
    private IProcess streetProcess;

    public void execute() {

        String res = null;
        try {
            res = HttpUtils.getHTML(naviBase + la);
        } catch (IOException e) {
        }

        streetProcess.proecss(res);

        try {
            res = HttpUtils.getHTML(naviBase + la + zip);
        } catch (IOException e) {
        }

        streetProcess.proecss(res);
        try {
            res = HttpUtils.getHTML(naviBase + la + zip + street);
        } catch (IOException e) {
        }

        streetProcess.proecss(res);
    }
}
