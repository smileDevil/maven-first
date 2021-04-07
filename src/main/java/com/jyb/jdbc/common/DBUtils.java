package com.jyb.jdbc.common;

import java.sql.*;

public class DBUtils {

    public  static Connection getConnection() throws SQLException, ClassNotFoundException {
        String SQLURL = "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String SQLUSER = "root";
        String SQLPSD = "rootroot";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(SQLURL, SQLUSER, SQLPSD);
        return  conn;
    }

    /***
     *关闭连接，释放资源
     * @param rs 结果集对象
     * @param stmt Statement对象
     * @param conn Connection对象
     */
    public  static  void closeConnection(ResultSet rs,Statement stmt,Connection conn){
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(stmt != null) {
                stmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(conn!=null && conn.isClosed() == false){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
