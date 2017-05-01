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
public class DetailSpider implements IProcess {

    public static void main(String[] args) {

        File f = new File("/Users/huodonghai/workspace/outsource/fangusa/fangusa-web/t");
        try {
            String text = FileUtils.readFileToString(f, "UTF-8");

            DetailSpider ds = new DetailSpider();
            ds.proecss(text);
        } catch (IOException e) {
        }

    }

    @Override
    public void proecss(String context) {

        System.out.println("response: " + context);

        Document doc = Jsoup.parse(context);

        Elements header = doc.select("header.zsg-content-header");
        Elements title = header.select(".notranslate");
        System.out.println(title.text());

        Elements elements = header.select("span.addr_bbs");
        for(Element e:elements){
            System.out.println(e.text());
        }

        Elements price = doc.select(".estimates");
        System.out.println(price.select(".main-row").first().select("span").first().text());

        Elements content = doc.select(".hdp-header-description").select(".zsg-content-item");
        System.out.println(content.text());

        Elements others = doc.select(".hdp-facts-expandable-container").select(".hdp-fact-ataglance-value");
        for(Element e:others){
            System.out.println(e.text());
        }

        Elements pics = doc.select(".photo-wall-content").select("li");
        for(Element e:pics){
            String src = e.select("img").attr("src");
            if(StringUtils.isEmpty(src)) {
                System.out.println(e.select("img").attr("href"));
            }else{
                System.out.println(e.select("img").attr("src"));
            }
        }


        Elements school = doc.select("ul.nearby-schools-list").select(".nearby-school");
        for(Element e:school){
            Elements rating = e.select(".nearby-schools-rating");
            Elements grade = e.select(".nearby-schools-grades");
            Elements distance = e.select(".nearby-schools-distance");
            Elements name = e.select(".nearby-schools-name");

            System.out.println(rating.select("span").text() + "  " + grade.text() + "  " + distance.text() + "  " + name.text());
        }

        // Tax history 是通过ajax后动态插入的
//        Elements tax = doc.select("#hdp-tax-history").select("tr");
//        int taxLimit = 3;
//        for(Element e:tax){
//            if(taxLimit == 0){
//                break;
//            }
//            System.out.println(e.child(0).text() + "  " + e.child(1).text());
//            taxLimit--;
//        }

        System.out.println("END!!!");
    }

}
