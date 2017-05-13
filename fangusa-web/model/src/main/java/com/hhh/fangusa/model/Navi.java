package com.hhh.fangusa.model;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public class Navi {

    private String state;
    private String county;
    private String postcode;
    private String street;

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Navi{" +
                "state='" + state + '\'' +
                ", county='" + county + '\'' +
                ", postcode='" + postcode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
