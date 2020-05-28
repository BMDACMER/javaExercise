package com.interview.javabasic.reflect;

public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("E:\\dev\\javaweb\\IDEA\\javaExercise\\interview\\target\\classes\\com\\interview\\javabasic\\reflect\\", "myClassLoader");
        Class c = m.loadClass("Robot");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
        System.out.println(c.getClassLoader().getParent().getParent().getParent());
        c.newInstance();
    }
}
