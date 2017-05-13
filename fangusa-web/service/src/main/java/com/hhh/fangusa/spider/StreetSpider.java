package com.hhh.fangusa.spider;

import com.google.common.collect.Lists;
import com.hhh.fangusa.job.IJobExecute;
import com.hhh.fangusa.parser.NaviBaseParser;
import com.hhh.fangusa.utils.HttpUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
@Component("streetSpider")
public class StreetSpider implements IJobExecute {

    static public final String naviBase = "https://www.zillow.com/";
    static public final String la = "ca/los-angeles-county/";
    static public final String zip = "90895/";
    static public final String street = "Linden Ave/";

    static public final String SLASH = "/";
    private static Logger logger = LogManager.getLogger(StreetSpider.class);

    @Value("${fangusa.seeds}")
    private String[] seeds;
    @Autowired
    private NaviBaseParser naviBaseParser;

    public static void main(String[] args) {

        String[] seeds = {"browse/homes/ca/los-angeles-county/"};
        StreetSpider ss = new StreetSpider();
        ss.setSeeds(seeds);
        ss.setNaviBaseParser(new NaviBaseParser());

        ss.execute();
    }

    public void setSeeds(String[] seeds) {
        this.seeds = seeds;
    }

    public void setNaviBaseParser(NaviBaseParser naviBaseParser) {
        this.naviBaseParser = naviBaseParser;
    }

    private String getResponse(String url) {
        System.out.println("get " + url);

        String res = null;
        res = HttpUtils.getHttps(url.replace(" ", "%20"), null);

        return res;
    }

    @Override
    public void execute() {
        if (seeds == null || seeds.length <= 0) {
            logger.info("seeds is empty, do nothing");
            return;
        }

        List<String> houseUrl = Lists.newArrayList();

        List<String> seedsUrl = Lists.newArrayList();
        for (String seed : seeds) {
            seedsUrl.add(naviBase + seed);
        }

        for (String seed : seeds) {
            String response = getResponse(naviBase + seed);

            List<String> zipcodes = naviBaseParser.parse(response);

            for (String zipcode : zipcodes) {
                String res = getResponse(naviBase + zipcode);

                List<String> streets = naviBaseParser.parse(res);

                for (String street : streets) {
                    String s = getResponse(naviBase + street);

                    List<String> houses = naviBaseParser.parse(s);

                    for (String house : houses) {
                        houseUrl.add(naviBase + house);
                    }
                }
            }
        }


        for (String house : houseUrl) {
            System.out.println(house);
        }
    }

}
