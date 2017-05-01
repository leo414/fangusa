package com.hhh.fangusa.model;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public class ResultStatus {
    // 未登陆
    public static final Integer NO_LOGGIN = -1;
    public static final String NO_LOGGIN_INFO = "请登录后重试";

    // 成功
    public static final Integer OK = 1;
    public static final String OK_INFO = "成功";

    // 缺少参数的错误
    public static final Integer PARAM_MISSING = 101;
    public static final String PARAM_MISSING_INFO = "缺少参数{0}";

    // 未归类的错误
    public static final Integer UNCLASSIFIED_ERROR = 998;

    // 未知错误
    public static final Integer ERROR_UNKNOW = 999;
    public static final String ERROR_UNKNOW_INFO = "内部错误";

    // confirmException
    public static final Integer NEED_CONFIRM = 666;
    public static final String NEED_CONFIRM_INFO = "需要用户确实";

}
