package juc.volatileTest;

public class LazySingleton {
    // 1 私有化构造器
    private LazySingleton() {
        System.out.println("懒汉式");
    }

    // 2 声明静态的私有化的实例对象
    private static volatile LazySingleton instance = null;

    // 3 创建静态实例
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
