package com.hhh.fangusa.model;

import java.util.Date;

public class Resource {
    private Long id;

    private Long no;

    private String zid;

    private String address;

    private Integer room;

    private Integer bath;

    private Integer size;

    private Integer year;

    private Integer type;

    private String name;

    private String cityName;

    private String streetName;

    private String countyName;

    private String stateName;

    private Long price;

    private String description;

    private String descCn;

    private Double area;

    private Integer carbarn;

    private String vr;

    private String propertyFee;

    private String landTax;

    private Long monthlyRent;

    private String monthlyRentTrend;

    private String school;

    private String pics;

    private Date createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid == null ? null : zid.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getBath() {
        return bath;
    }

    public void setBath(Integer bath) {
        this.bath = bath;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName == null ? null : streetName.trim();
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName == null ? null : stateName.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDescCn() {
        return descCn;
    }

    public void setDescCn(String descCn) {
        this.descCn = descCn == null ? null : descCn.trim();
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getCarbarn() {
        return carbarn;
    }

    public void setCarbarn(Integer carbarn) {
        this.carbarn = carbarn;
    }

    public String getVr() {
        return vr;
    }

    public void setVr(String vr) {
        this.vr = vr == null ? null : vr.trim();
    }

    public String getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(String propertyFee) {
        this.propertyFee = propertyFee == null ? null : propertyFee.trim();
    }

    public String getLandTax() {
        return landTax;
    }

    public void setLandTax(String landTax) {
        this.landTax = landTax == null ? null : landTax.trim();
    }

    public Long getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Long monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getMonthlyRentTrend() {
        return monthlyRentTrend;
    }

    public void setMonthlyRentTrend(String monthlyRentTrend) {
        this.monthlyRentTrend = monthlyRentTrend == null ? null : monthlyRentTrend.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", no=" + no +
                ", zid='" + zid + '\'' +
                ", address='" + address + '\'' +
                ", room=" + room +
                ", bath=" + bath +
                ", size=" + size +
                ", year=" + year +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", countyName='" + countyName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", descCn='" + descCn + '\'' +
                ", area=" + area +
                ", carbarn=" + carbarn +
                ", vr='" + vr + '\'' +
                ", propertyFee='" + propertyFee + '\'' +
                ", landTax='" + landTax + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", monthlyRentTrend='" + monthlyRentTrend + '\'' +
                ", school='" + school + '\'' +
                ", pics='" + pics + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
