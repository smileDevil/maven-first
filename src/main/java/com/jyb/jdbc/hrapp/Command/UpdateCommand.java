package com.jyb.jdbc.hrapp.Command;

import com.jyb.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateCommand implements  Command{
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入部门");
        String dname = in.next();
        System.out.println("薪资");
        float salary = in.nextFloat();
        Connection conn = null;
        try {
             conn = DBUtils.getConnection();
             String sql = "update  employee set salary = salary + ? where dname = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setFloat(1,salary);
            stmt.setString(2,dname);
            int cnt = stmt.executeUpdate();
            if(cnt > 0) {
                System.out.println(dname +cnt+ "人员薪资增长:"+salary);
            }else{
                System.out.println("未找到满足条件人员");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(null,null,conn);
        }
    }
}
