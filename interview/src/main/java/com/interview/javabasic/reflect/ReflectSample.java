package com.interview.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws Exception{
        Class rc = Class.forName("com.interview.javabasic.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        // ��ӡ������
        System.out.println("Class name is " + rc.getName());
        // ����˽�з���
        Method getHello = rc.getDeclaredMethod("throwHello",String.class);
        getHello.setAccessible(true);
        Object str = getHello.invoke(r,"Bob");
        System.out.println("getHello result is " + str);

        // ����public����
        Method sayHi = rc.getMethod("sayHi",String.class);
        sayHi.invoke(r,"Welcome");
//        sayHi.invoke(r);

        // ����Field��Ա����
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r,"Alice");
        sayHi.invoke(r,"Welcome");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
