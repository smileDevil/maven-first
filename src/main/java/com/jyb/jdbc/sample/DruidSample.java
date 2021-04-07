package com.jyb.jdbc.sample;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jyb.jdbc.common.DBUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidSample {
    public static void main(String[] args) {
        //加载属性文件
        Properties properties = new Properties();
        String propertyFile = DruidSample.class.getResource("/druid-config.properties").getPath();
        try {
            //URLDecoder().decode 把 %20变回/
            propertyFile = new URLDecoder().decode(propertyFile,"UTF-8");
            properties.load(new FileReader(propertyFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //获取dataSource数据源对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            conn =  dataSource.getConnection();
            pstmt = conn.prepareStatement("select * from  employee limit 0,10");
            rs =pstmt.executeQuery();
            while (rs.next()){
                String ename = rs.getString("ename");
                System.out.println(ename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(rs,pstmt,conn);
        }
        //创建数据库连接
    }
}
