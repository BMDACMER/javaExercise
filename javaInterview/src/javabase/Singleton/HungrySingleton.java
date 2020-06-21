package javabase.Singleton;

/**
 * 饿汉式
 */
public class HungrySingleton {
    // 1 私有化类构造器
    private HungrySingleton() {
        System.out.println("饿汉式");
    }

    // 2 声明当前类对象，此对象必须为static
    private static volatile HungrySingleton hungrySingleton = new HungrySingleton();

    // 3 提供公共的静态方法，返回类的对象
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

}
