package javabase.Singleton;

public class LazySingleton {
    // 1 声明私有化构造方法
    private LazySingleton() {
        System.out.println("懒汉式");
    }

    // 2 初始化当前类
    private static volatile LazySingleton instance = null;

    // 3 返回类的对象
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
