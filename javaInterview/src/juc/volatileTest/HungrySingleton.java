package juc.volatileTest;

public class HungrySingleton {
    //1.私化类的构造器
    private HungrySingleton() {
        System.out.println("饿汉式");
    }

    //2.声明当前类对象,此对象也必须声明为static的
    private static volatile HungrySingleton instance = new HungrySingleton();

    //3.提供公共的静态的方法，返回类的对象
    public static HungrySingleton getInstance() {
        return instance;
    }
}
