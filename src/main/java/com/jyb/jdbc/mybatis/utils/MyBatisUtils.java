package com.jyb.jdbc.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * MyBatisUtils工具类，创建一个全局唯一的SqlSessionFactory对象
 *
 */
public class MyBatisUtils {
    //通过静态全剧对象唯一性
    private static SqlSessionFactory sqlSessionFactory = null;
    //static 块用于 初始化 静态对象
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            //初始化时异常， 调用者可以查看
            throw new ExceptionInInitializerError(e);
        }
    }
    //创建一个新的sqlsession
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
    //关闭sqlseeion
    public static void closeSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
