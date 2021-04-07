package com.jyb.jdbc.sample;

import com.jyb.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionSample {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into employee (eno,ename,salary,dname) value(?,?,?,?)";
            for (int i = 1000 ; i<2000;i++){
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
}
