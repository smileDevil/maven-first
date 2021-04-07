package com.jyb.spring.ioc.dao;


public class BookDaoImpl implements BookDao {
    @Override
    public void insert() {
        System.out.println("向数据库插入一跳数据");
    }
}
