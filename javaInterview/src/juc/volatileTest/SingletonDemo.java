package juc.volatileTest;

// 单例模式
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 构造方法SingleDemo()");
    }

    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // 单线程
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());
        System.out.println("===================");
        // 多线程   20个线程
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                getInstance();
            }, String.valueOf(i+1)).start();
        }
    }
}
