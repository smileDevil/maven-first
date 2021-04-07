package com.jyb.jdbc.sample;

import java.sql.*;

/**
 * 标准jdbc操作5步骤
 */
public class StandardJDBCSample {
    public static void main(String[] args) {
        String SQLURL = "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String SQLUSER = "root";
        String SQLPSD = "rootroot";
        Connection conn = null;
        Statement stmt = null;
        try {
            //1加载并注册jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2 创建数据库连接
        try {

            conn = DriverManager.getConnection(SQLURL, SQLUSER, SQLPSD);
            //3 创建statement对象
            stmt = conn.createStatement();

            //4 便利查询结果
            ResultSet rs = stmt.executeQuery("select * from employee");
            while (rs.next()) {
                Integer eno = rs.getInt(1);
                String ename = rs.getString(2);
                System.out.println(ename);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && conn.isClosed() == false) {
                    //5 关闭连接，释放资源
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
