package com.jyb.jdbc.mybatis.dto;

import com.jyb.jdbc.mybatis.entity.Category;
import com.jyb.jdbc.mybatis.entity.Goods;

public class GoodsDTO {
    //对Goods对行进行扩展
    private  Goods goods = new Goods();
    private Category category = new Category();
    private String test;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
