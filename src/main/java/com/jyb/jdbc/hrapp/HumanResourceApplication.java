package com.jyb.jdbc.hrapp;

import com.jyb.jdbc.hrapp.Command.*;

import java.util.Scanner;

public class HumanResourceApplication {
    public static void main(String[] args) {
        System.out.println("1-查询部门员工,2-插入部门人员 3-更新工资 4-删除员工 5-分页查询员工数据");
        Scanner in = new Scanner(System.in);
        Integer cmd = in.nextInt();
        Command command = null;
        switch (cmd){
            case 1 : //查询员工部门
                command = new PstmtQueryCommand(); // 防止sql注入
                command.execute();
                break;
            case 2 :
                command = new InsertCommand();
                command.execute();
                break;
            case 3 :
                command = new UpdateCommand();
                command.execute();
                break;
            case 4:
                command = new DeleteCommand();
                command.execute();
                break;
            case 5:
                command = new PaginationCommand();
                command.execute();
        }
    }
}
