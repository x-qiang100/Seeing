package com.seeing.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties properties = new Properties();
    private static final String file = "";
    public static String getProperties(String key){


        InputStream inputStream = null;
        String value = "";
        try {
            inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("seeing.properties");
            properties.load(inputStream);
            value = properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }


}
