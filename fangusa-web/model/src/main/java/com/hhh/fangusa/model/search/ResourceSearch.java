package com.hhh.fangusa.model.search;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public class ResourceSearch {

    private Long id;
    private String state;
    private String county;
    private String zip;
    private String street;
    private String pics;
    private String address;
    private Integer beds;
    private Integer baths;
    private Long area;
    private Integer yearBuilt;
    private Integer type;
    private String city;
    private Long price;
    private String detail;
    private Integer parking;
    private String vrLink;
    private String school;
    private String taxHistory;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getParking() {
        return parking;
    }

    public void setParking(Integer parking) {
        this.parking = parking;
    }

    public String getVrLink() {
        return vrLink;
    }

    public void setVrLink(String vrLink) {
        this.vrLink = vrLink;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTaxHistory() {
        return taxHistory;
    }

    public void setTaxHistory(String taxHistory) {
        this.taxHistory = taxHistory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getState()).append("-").append(this.getCounty()).append("-").append(this.getZip())
                .append("-").append(this.getStreet());
        sb.append(this.getId()).append("-").append(this.getAddress()).append("-").append(this.getArea())
                .append("-").append(this.getBaths()).append("-").append(this.getBeds());

        return sb.toString();
    }
}
