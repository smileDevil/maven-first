package com.jyb.spring.ioc;

import com.jyb.spring.ioc.entity.Apple;
import com.jyb.spring.ioc.entity.Child;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        //classpath当前类路径下查找
        //context 指代IoC容器
//基本使用 利用setxxx 注入依赖
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Apple apple = context.getBean("sweetApple", Apple.class);
        System.out.println(apple.getTitle());
        Child child = context.getBean("andy", Child.class);
        child.eat();

//        Apple apple1 = context.getBean("apple1",Apple.class);
    }
}
