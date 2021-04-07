package com.jyb.jdbc.hrapp.Command;

import com.jyb.jdbc.common.DBUtils;
import com.jyb.jdbc.hrapp.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaginationCommand implements  Command{
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入页号：");
        int page = in.nextInt();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList();
        try {
            conn = DBUtils.getConnection();
            String sql = "select * from employee limit ?,10";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,(page - 1) * 10);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Integer eno =  rs.getInt("eno");
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                Date hiredate = rs.getDate("hiredate");
                Employee emp = new Employee();
                emp.setEno(eno);
                emp.setEname(ename);
                emp.setDname(dname);
                emp.setSalary(salary);
                emp.setHiredate(hiredate);
                list.add(emp);
            }
            System.out.println(list.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(rs,pstmt,conn);
        }
    }
}
