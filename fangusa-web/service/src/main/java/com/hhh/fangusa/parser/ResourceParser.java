package com.hhh.fangusa.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hhh.fangusa.model.Resource;
import com.hhh.fangusa.model.ResourceType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@Component("resourceParser")
public class ResourceParser implements IParser<Resource> {
    private static Logger logger = LogManager.getLogger(ResourceParser.class);

    public static void main(String[] args) {

        File f = new File("/Users/huodonghai/workspace/outsource/fangusa/git/fangusa/fangusa-web/t");
        try {
            String text = FileUtils.readFileToString(f, "UTF-8");

            ResourceParser parser = new ResourceParser();
            Resource resource = parser.parse(text);
            resource.setZid("ddd");

            System.out.println(resource);


        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
    @Override
    public Resource parse(String text) {
        Resource resource = new Resource();
        Document doc = Jsoup.parse(text);

        Elements header = doc.select("header.zsg-content-header");
        Elements title = header.select(".notranslate");
        resource.setAddress(title.text());

        Elements elements = header.select("span.addr_bbs");
        for (int i = 0; i < elements.size(); i++) {
            Element e = elements.get(i);
            if (i == 0) {
                resource.setRoom(Integer.valueOf(e.text().split("beds")[0].trim()));
            }
            if (i == 1) {
                resource.setBath(Integer.valueOf(e.text().split("baths")[0].trim()));
            }
            if (i == 2) {
                resource.setSize(Integer.valueOf(e.text().split("sqft")[0].trim().replace(",", "")));
            }
        }

        Elements price = doc.select(".estimates");
        String priceStr = price.select(".main-row").first().select("span").first().text();
        resource.setPrice(Long.valueOf(StringUtils.replace(StringUtils.replace(priceStr, "$", ""), ",", "")));

        Elements content = doc.select(".hdp-header-description").select(".zsg-content-item");
        resource.setDescription(content.text());

        Elements others = doc.select(".hdp-facts-expandable-container").select(".hdp-fact-ataglance-value");
        for (int i = 0; i < others.size(); i++) {
            Element e = others.get(i);
            if (i == 0) {
                resource.setType(ResourceType.nameOf(e.text()).getValue());
            }
            if (i == 1) {
                resource.setYear(Integer.valueOf(e.text()));
            }
            if (i == 4) {
                resource.setCarbarn(Integer.valueOf(e.text().split("spaces")[0].trim()));
            }
            if (i == 5) {
                resource.setMonthlyRent(Long.valueOf(e.text().split("/month")[0].replace("$", "")));
            }
        }

        Elements pics = doc.select(".photo-wall-content").select("li");
        JSONArray jaPics = new JSONArray();
        for (Element e : pics) {
            String src = e.select("img").attr("src");
            if (StringUtils.isEmpty(src)) {
                jaPics.add(e.select("img").attr("href"));
            } else {
                jaPics.add(e.select("img").attr("src"));
            }
        }
        resource.setPics(jaPics.toJSONString());

        JSONArray jaSchool = new JSONArray();
        Elements school = doc.select("ul.nearby-schools-list").select(".nearby-school");
        for (Element e : school) {
            JSONObject jo = new JSONObject();
            Elements rating = e.select(".nearby-schools-rating");
            jo.put("rating", rating.text());
            Elements grade = e.select(".nearby-schools-grades");
            jo.put("grade", grade.text());
            Elements distance = e.select(".nearby-schools-distance");
            jo.put("distance", distance.text());
            Elements name = e.select(".nearby-schools-name");
            jo.put("name", name.text());

            jaSchool.add(jo);
        }
        resource.setSchool(jaSchool.toJSONString());

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

        logger.info("resouece: {}", resource);

        return resource;
    }
}

