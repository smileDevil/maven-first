package com.jyb.spring.ioc.factory;

import com.jyb.spring.ioc.entity.Apple;

/***
 * 静态工厂， 通过静态方法创建对象，隐藏创建细节
 */
public class AppleStaticFactory {
    public static Apple createSweetApple(){
        Apple apple = new Apple("红富士","红色","欧洲");
        return apple;
    }
}
