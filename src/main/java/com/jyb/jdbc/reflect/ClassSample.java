package com.jyb.jdbc.reflect;

import com.jyb.jdbc.hrapp.entity.Employee;

import java.lang.reflect.InvocationTargetException;

public class ClassSample {
    public static void main(String[] args) {
        try {
            //Class.forName将指定的类加载到jvm中， 并返回对应class对象
            Class employeeClass =  Class.forName("com.jyb.jdbc.hrapp.entity.Employee");
            System.out.println("Emloyee已被加载到jvm");
            try {
                //class 是通过默认构造方法创建对象
               Employee employee = (Employee) employeeClass.getDeclaredConstructor().newInstance();
                System.out.println(employee);
            } catch (InstantiationException e) {
                //对象无法实例化异常
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                //非法访问，当在作用于外访问对象方法 或者成员变量
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
