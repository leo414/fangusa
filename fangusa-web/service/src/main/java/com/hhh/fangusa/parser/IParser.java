package com.hhh.fangusa.parser;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public interface IParser<T> {

    T parse(String text);
}
