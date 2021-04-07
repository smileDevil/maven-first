package com.jyb.jdbc.hrapp.entity;

import java.util.Date;

/**
 * 员工实体类
 */
public class Employee {
    /**javabean 要求
     * 1 具备默认构造函数
     * 属性私有
     * 具有get set
     */
    private Integer eno;
    private String ename;
    private Float salary;
    private String dname;
    private Date hiredate;
    public Employee(){
        System.out.println("Employee默认方法已经被执行");
    }
    //代参数构造方法
    public Employee(Integer eno,String ename,Float salary,String dname){
        this.eno = eno;
        this.ename = ename;
        this.salary = salary;
        this.dname = dname;
        System.out.println("employee带参方法已经被执行");
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", dname='" + dname + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }

    public Employee updateSalary(Float val){
        this.salary = this.salary + val ;
        System.out.println(this.ename + "调薪至" + this.salary);
        return this;
    }
}
