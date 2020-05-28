package com.interview.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws Exception{
        Class rc = Class.forName("com.interview.javabasic.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        // 打印出类名
        System.out.println("Class name is " + rc.getName());
        // 访问私有方法
        Method getHello = rc.getDeclaredMethod("throwHello",String.class);
        getHello.setAccessible(true);
        Object str = getHello.invoke(r,"Bob");
        System.out.println("getHello result is " + str);

        // 访问public方法
        Method sayHi = rc.getMethod("sayHi",String.class);
        sayHi.invoke(r,"Welcome");
//        sayHi.invoke(r);

        // 访问Field成员变量
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r,"Alice");
        sayHi.invoke(r,"Welcome");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
