package com.jyb.jdbc.reflect;

import com.jyb.jdbc.hrapp.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodSample {
    public static void main(String[] args) {
        try {
            Class employeeClass =  Class.forName("com.jyb.jdbc.hrapp.entity.Employee");
            try {
                Constructor constructor =  employeeClass.getConstructor(new Class[]{
                   Integer.class,String.class,Float.class,String.class
                });
                try {
                    Employee employee = (Employee) constructor.newInstance(new Object[]{1,"wangmeimei",10000f,"研发部"});
                    //两个参数， 前面是方法名， 后面是参数类型， 因为存在重载的问题， 所以要明确该方法名类型
                    Method updateSalaryMethod = employeeClass.getMethod("updateSalary",new Class[]{Float.class});
//                    Employee employee1 = (Employee) updateSalaryMethod.invoke(employee,new Object[]{1000f});
//                    System.out.println(employee1);
                    try {
                        Field enameFiled = employeeClass.getDeclaredField("ename");
                        enameFiled.setAccessible(true); // 因为是私有变量， 所以需要使用setAccessible
                        String ename = (String) enameFiled.get(employee);
                        System.out.println("改变前名字" + ename);
                        enameFiled.set(employee,"大海");
                        System.out.println("改变后的人员" + employee);
//                        enameFiled.set(employee,"王华");
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
