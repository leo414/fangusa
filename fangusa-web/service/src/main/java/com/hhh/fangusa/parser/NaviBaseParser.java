package com.hhh.fangusa.parser;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
@Component("naviBaseParser")
public class NaviBaseParser implements IParser<List<String>> {

    @Override
    public List<String> parse(String text) {
        if(StringUtils.isEmpty(text)){
            return Lists.newArrayList();
        }

        Document doc = Jsoup.parse(text);

        List<String> ret = Lists.newArrayList();
        Elements li = doc.select(".browse-content").select("li").select("a");
        for (Element e : li) {
            String link = e.attr("href");
            if (link.startsWith("/browse/homes/") || link.startsWith("/homedetails/")) {
                ret.add(link);
            }
        }

        return ret;
    }
}
