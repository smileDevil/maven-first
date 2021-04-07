package com.jyb.jdbc.sample;

import com.jyb.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchSample {
    //标准插入数据
    private  static void tc1(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into employee (eno,ename,salary,dname) value(?,?,?,?)";
            for (int i = 100000 ; i<200000;i++){
//                if(i == 1005){
//                    //这里操作会执行rollback，回滚，插入的数据都会删掉
//                    throw  new RuntimeException("插入失败");
//                }
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,i);
                pstmt.setString(2,"员工" +i);
                pstmt.setFloat(3,4000);
                pstmt.setString(4,"研发部");
                pstmt.executeUpdate();

            }
            conn.commit(); //当设置了aotocommit为false后，需要手动commit 提交事务中的数据

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                if (conn!=null && conn.isClosed() ==false){
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(null,pstmt,conn);
        }

    }
//使用批处理插入若干数据
    private  static void tc2(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into employee (eno,ename,salary,dname) value(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            for (int i = 100000 ; i<200000;i++){
                pstmt.setInt(1,i);
                pstmt.setString(2,"员工" +i);
                pstmt.setFloat(3,4000);
                pstmt.setString(4,"研发部");
//                pstmt.executeUpdate();
                pstmt.addBatch();//批处理就不能使用excuteUpdate ，而是先加入到批量处理
            }
            pstmt.executeBatch();//这里进行批处理
            conn.commit(); //当设置了aotocommit为false后，需要手动commit 提交事务中的数据

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                if (conn!=null && conn.isClosed() ==false){
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(null,pstmt,conn);
        }

    }
    public static void main(String[] args) {
        tc2();
    }
}
