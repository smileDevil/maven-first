package com.jyb.jdbc.reflect;

import com.jyb.jdbc.hrapp.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorSample {
    public static void main(String[] args) {
        Class employeeClass = null;
        try {
            employeeClass = Class.forName("com.jyb.jdbc.hrapp.entity.Employee");

            try {
                Constructor constructor = employeeClass.getConstructor(new Class[]{Integer.class,String.class,Float.class,String.class});
                Employee employee = (Employee) constructor.newInstance(new Object[]{1,"王梅梅",6000f,"研发部"});
                System.out.println(employee);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                //方法申明不一致报错
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
