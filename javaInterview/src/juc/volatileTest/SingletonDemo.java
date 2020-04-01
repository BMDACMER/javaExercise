package juc.volatileTest;

// ����ģʽ
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t ���췽��SingleDemo()");
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
        // ���߳�
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());
//        System.out.println(getInstance() == getInstance());
        System.out.println("===================");
        // ���߳�   20���߳�
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                getInstance();
            }, String.valueOf(i+1)).start();
        }
    }
}
