package com.hhh.fangusa.model;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public class JSONResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public JSONResult() {
        this.code = ResultStatus.OK;
        this.msg = ResultStatus.OK_INFO;
    }

    public JSONResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(T data) {
        this.code = ResultStatus.OK;
        this.msg = ResultStatus.OK_INFO;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
