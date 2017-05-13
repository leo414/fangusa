package com.hhh.fangusa.model;

/**
 * @Author: huodonghai
 * @Copyright (c) 2016, lianjia.com All Rights Reserved
 */
public enum ResourceType {
    CONDO("Condo", 1);

    private String name;
    private Integer value;

    private ResourceType(String name, Integer value) {
        this.value = value;
        this.name = name;
    }

    public static ResourceType valueOf(Integer value) {
        if (null == value) {
            return null;
        }
        for (ResourceType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public static ResourceType nameOf(String name) {
        if (null == name) {
            return null;
        }
        for (ResourceType type : values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        return null;
    }

    public static String name(Integer value) {
        ResourceType item = valueOf(value);
        return (null != item) ? item.getName() : "";
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public boolean expect(Integer value) {
        return (null != value) ? this.getValue() == value : false;
    }
}
