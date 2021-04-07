package com.jyb.jdbc.hrapp.Command;

import com.jyb.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCommand implements  Command{
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("员工姓名");
        String ename = in.next();
        Connection conn = null;
        try {
             conn = DBUtils.getConnection();
             String sql = "delete from employee where ename = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,ename);
            int cnt = stmt.executeUpdate();
            if(cnt == 1) {

                System.out.println(ename + "离职了");
            }else{
                System.out.println("未找到该人员");
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
