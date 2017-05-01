package com.hhh.fangusa.utils;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderSupport;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class ApplicationPropertiesSupport extends PropertiesLoaderSupport implements FactoryBean<Map<String, Properties>>, InitializingBean {
    private static final String DEFAULT_KEY = "default";
    private boolean singleton = true;
    private Map<String, Properties> singletonInstance;
    private Map<String, Resource> resourceMap;
    private String fileEncoding;
    private boolean ignoreResourceNotFound = false;

    public ApplicationPropertiesSupport() {
    }

    public void afterPropertiesSet() throws Exception {
        if (this.singleton) {
            this.singletonInstance = this.createProperties();
        }

    }

    private Map<String, Properties> createProperties() throws IOException {
        HashMap propertiesMap = new HashMap();
        Properties defaultProperties = this.mergeProperties();
        propertiesMap.put("default", defaultProperties);
        this.loadMapProperties(propertiesMap);
        return propertiesMap;
    }

    private void loadMapProperties(Map<String, Properties> propertiesMap) throws IOException {
        if (this.resourceMap != null) {
            Iterator i$ = this.resourceMap.keySet().iterator();

            while (i$.hasNext()) {
                String key = (String) i$.next();
                Properties props = new Properties();
                Resource location = (Resource) this.resourceMap.get(key);
                if (this.logger.isInfoEnabled()) {
                    this.logger.info("Loading properties file from " + location);
                }

                try {
                    PropertiesLoaderUtils.fillProperties(props, new EncodedResource(location, this.fileEncoding));
                    propertiesMap.put(key, props);
                } catch (IOException var7) {
                    if (!this.ignoreResourceNotFound) {
                        throw var7;
                    }

                    if (this.logger.isWarnEnabled()) {
                        this.logger.warn("Could not load properties from " + location + ": " + var7.getMessage());
                    }
                }
            }
        }

    }

    public Map<String, Properties> getObject() throws Exception {
        return this.singleton ? this.singletonInstance : this.createProperties();
    }

    public Class<Map> getObjectType() {
        return Map.class;
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public Map<String, Resource> getResourceMap() {
        return this.resourceMap;
    }

    public void setResourceMap(Map<String, Resource> resourceMap) {
        this.resourceMap = resourceMap;
    }
}
