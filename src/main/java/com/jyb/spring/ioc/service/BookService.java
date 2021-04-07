package com.jyb.spring.ioc.service;

import com.jyb.spring.ioc.dao.BookDao;

public class BookService {
    private BookDao bookDao;
    //采购书
    public  void purchase(){
        System.out.println("正在执行图书采购方法");
        bookDao.insert();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
