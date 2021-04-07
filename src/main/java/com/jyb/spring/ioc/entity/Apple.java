package com.jyb.spring.ioc.entity;

public class Apple {
    private String title;
    private String color;
    private String origin;

    public Apple() {
//        System.out.println("通过默认构造方法创建了对象");
    }

    public Apple(String title, String color, String origin) {
//        System.out.println("通过带参构造方法创建了对象");
        this.title = title;
        this.color = color;
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
