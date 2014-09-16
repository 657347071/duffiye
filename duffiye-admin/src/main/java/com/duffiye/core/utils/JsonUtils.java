package com.duffiye.core.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {
    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "{error:\"" + e.getMessage() + "\"}";
        }
    }

    public static <T> T fromUrl(URL src, Class<T> valueType) {
        try {
            return mapper.readValue(src, valueType);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <T> T fromString(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        String url = "http://m.weather.com.cn/data/101250101.html";
        try {
            Map map = fromUrl(new URL(url), Map.class);
            System.out.println(map);
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
        }
    }

}
