package com.jyb.spring.ioc;

import com.jyb.spring.ioc.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookShopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        BookService service = context.getBean("bookService",BookService.class);
        service.purchase();
    }
}
