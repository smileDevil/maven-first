package com.jyb.jdbc.hrapp.Command;

import com.jyb.jdbc.common.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InsertCommand implements  Command{
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("员工编号");
        int eno = in.nextInt();
        System.out.println("员工姓名");
        String ename = in.next();
        System.out.println("薪资");
        float salary = in.nextFloat();
        System.out.println("部门");
        String dname = in.next();
        System.out.println("入职日期");
        String strHiredate = in.next();
        //1String 专程java.util.date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date udJoredate = null;
        try {
            udJoredate = sdf.parse(strHiredate);
            //2 java.util.date转 java.sql.date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = udJoredate.getTime();//自1970年到现在毫秒数
        java.sql.Date sdHireDate = new java.sql.Date(time);
        Connection conn = null;
        try {
             conn = DBUtils.getConnection();
             String sql = "insert into employee (eno,ename,salary,dname,hiredate) value(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,eno);
            stmt.setString(2,ename);
            stmt.setFloat(3,salary);
            stmt.setString(4,dname);
            stmt.setDate(5,sdHireDate);//date是java.sql.date
            int cnt = stmt.executeUpdate();
             System.out.println(cnt);
            System.out.println(ename + "员工入职手续办理完成");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(null,null,conn);
        }
    }
}
