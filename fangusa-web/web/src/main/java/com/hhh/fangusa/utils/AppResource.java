package com.hhh.fangusa.utils;

import java.util.Map;
import java.util.Properties;

public class AppResource {
    private static final String DEFAULT_PROPERTIES = "default";
    private static Map<String, Properties> properties;

    public AppResource() {
    }

    private static Map<String, Properties> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Properties> properties) {
        AppResource.properties = properties;
    }

    public static String get(String key) {
        return ((Properties) getProperties().get("default")).getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return ((Properties) getProperties().get("default")).getProperty(key, defaultValue);
    }

    public static String getByFileKey(String fileKey, String key) {
        return ((Properties) getProperties().get(fileKey)).getProperty(key);
    }

    public static String getByFileKey(String fileKey, String key, String defaultValue) {
        return ((Properties) getProperties().get(fileKey)).getProperty(key, defaultValue);
    }
}
