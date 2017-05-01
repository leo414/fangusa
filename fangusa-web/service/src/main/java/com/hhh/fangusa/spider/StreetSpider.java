package com.hhh.fangusa.spider;

import com.hhh.fangusa.job.IProcess;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
@Component
public class StreetSpider implements IProcess {

    public static void main(String[] args) {

        File f = new File("/Users/huodonghai/workspace/outsource/fangusa/fangusa-web/s");
        try {
            String text = FileUtils.readFileToString(f, "UTF-8");

            StreetSpider ds = new StreetSpider();
            ds.proecss(text);
        } catch (IOException e) {
        }

    }

    @Override
    public void proecss(String context) {

        System.out.println("response: " + context);

        Document doc = Jsoup.parse(context);

        Elements li = doc.select(".browse-content").select("li").select("a");
        for(Element e:li){
            if(e.attr("href").startsWith("/browse/homes/"))
            {
                System.out.println(e.text());
            }
        }


    }

}
