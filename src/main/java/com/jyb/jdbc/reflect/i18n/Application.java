package com.jyb.jdbc.reflect.i18n;

import com.jyb.jdbc.i18n.factory.i18n.I18N;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class Application {
    public  static  void  say(){
        Properties properties = new Properties();
        String configPath =  Application.class.getResource("/config.properties").getPath();
        try {
            //获取到不包含任何标识的路径
            configPath = new URLDecoder().decode(configPath,"UTF-8");
            properties.load(new FileInputStream(configPath));
            String language = properties.getProperty("language");
            I18N i18N = (I18N)Class.forName(language).getDeclaredConstructor().newInstance();
            System.out.println(i18N.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        say();
    }
}
