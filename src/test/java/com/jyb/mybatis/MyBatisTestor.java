package com.jyb.mybatis;

import com.jyb.jdbc.mybatis.dto.GoodsDTO;
import com.jyb.jdbc.mybatis.entity.Goods;
import com.jyb.jdbc.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTestor {
    @Test
    public void testSqlSessionFactory() throws IOException {
        //读取到配置文件
       Reader reader =Resources.getResourceAsReader("mybatis-config.xml");
       //通过SqlSessionFactoryBuilder构造者模式 来初始化SqlSessionFactory
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
       System.out.println("初始化成功");
       //创建一个SqlSession对象 SqlSession是jdbc的扩展累，用于与数据库交互
        SqlSession sqlSession = null;
        try {
            sqlSession =  sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void testMyBatisUtils(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            System.out.println(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            List<Goods> list = session.selectList("goods.selectAll");
            for(Goods good : list){
                System.out.println(good.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSelectById(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            Goods good = session.selectOne("selectById",740);
            System.out.println(good.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSelectByPriceRange(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            Map param = new HashMap();
            param.put("min",10);
            param.put("max",100);
            List<Goods> list = session.selectList("goods.selectByPriceRange",param);
            for(Goods good : list){
                System.out.println(good.getTitle() + good.getCurrentPrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSelectGoodsMap(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            List<Map> list = session.selectList("goods.selectGoodsMap");
            for(Map good : list){
                System.out.println(good);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSelectGoodsDTO(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            List<GoodsDTO> list = session.selectList("goods.selectGoodsDTO");
            for(GoodsDTO good : list){
                System.out.println(good.getCategory().getCategoryId() +good.getCategory().getCategoryName()+"--" + good.getGoods().getTitle()+"test"+good.getTest());
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testGoodsInsert(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            Goods good = new Goods();
            good.setTitle("测试商品");
            good.setSubTitle("测试商品");
            good.setOriginalCost(100f);
            good.setDiscount(0.3f);
            good.setCurrentPrice(30f);
            good.setCategoryId(6);
            //代表本次成功插入对记录总数
            int num =  session.insert("insert",good);
            //提交事务数据， 只有提交了，才能从事务写入数据库
            session.commit();
            System.out.println("成功插入了"+num+"跳数据" + good.getGoodsId());
        } catch (Exception e) {
            if(session!=null){
                session.rollback();
            }
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testInsertUserGeneratedKeys(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            Goods good = new Goods();
            good.setTitle("测试商品");
            good.setSubTitle("测试商品");
            good.setOriginalCost(100f);
            good.setDiscount(0.3f);
            good.setCurrentPrice(30f);
            good.setCategoryId(6);
            //代表本次成功插入对记录总数
            int num =  session.insert("insertUserGeneratedKeys",good);
            //提交事务数据， 只有提交了，才能从事务写入数据库
            session.commit();
            System.out.println("成功插入了"+num+"跳数据" + good.getGoodsId());
        } catch (Exception e) {
            if(session!=null){
                session.rollback();
            }
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testUpdateGoods(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            Goods good = session.selectOne("selectById",740);

            System.out.println("当前价格"+good.getOriginalCost());
            good.setOriginalCost(3330f);
            //代表本次成功插入对记录总数
            int num =  session.update("updateGoods",good);
            //提交事务数据， 只有提交了，才能从事务写入数据库
            session.commit();
            System.out.println("更新成功了"+num+"条数据 价格变成了");
        } catch (Exception e) {
            if(session!=null){
                session.rollback();
            }
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }


    }


    @Test
    public void testDeleteGoods() {
        SqlSession session = null;
        try {
            session = MyBatisUtils.openSession();
            //代表本次成功插入对记录总数
            int num = session.delete("deleteGoods", 753);
            //提交事务数据， 只有提交了，才能从事务写入数据库
            session.commit();
            System.out.println("成功删除一套数据");
        } catch (Exception e) {
            if (session != null) {
                session.rollback();
            }
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSession(session);
        }
    }
}
