package com.jyb.jdbc.hrapp.Command;

import java.sql.*;
import java.util.Scanner;

public class QueryCommand implements Command {
    String SQLURL = "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    String SQLUSER = "root";
    String SQLPSD = "rootroot";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs =null;
    @Override
    public void execute() {
        System.out.println("打印部门名称");
        Scanner in = new Scanner(System.in);
        String pdame = in.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(SQLURL,SQLUSER,SQLPSD);
            stmt = conn.createStatement();
//            ResultSet 结果集
            rs = stmt.executeQuery("select * from employee where dname='" + pdame + "' ");
            //循环遍历 rs.next是否存在下一条数据
            while (rs.next()){
                Integer eno = rs.getInt(1);//JDBC中索引从1 开始 而不是数组的0
                String ename = rs.getString(2);
                String dename = rs.getString(3);
                System.out.println(ename + "  " + dename);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

            try {
                if(conn!=null && conn.isClosed() == false){
                    conn.close();
                }
            }catch (Exception e){

            }
        }
    }
}
