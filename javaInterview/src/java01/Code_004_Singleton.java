package java01;

public class Code_004_Singleton {
    // 饿汉式 的单例模式
    private static volatile Code_004_Singleton instance = null;

    private Code_004_Singleton(){
        System.out.println(Thread.currentThread().getName() + "\t我是构造方法Singleton");
    }

    //  方法一
//    public static synchronized Code_004_Singleton getInstance(){
//        if (instance == null){
//            instance = new Code_004_Singleton();
//        }
//        return instance;
//    }
    // DCL(Double check Lock双端检锁机制)  方法二
    // 不一定线程安全，原因是有指令重排序的存在，加入volatile可以禁止指令重排
    public static Code_004_Singleton getInstance(){
        if (instance == null){
            synchronized (Code_004_Singleton.class){
                if (instance == null)
                    instance = new Code_004_Singleton();
            }
        }
        return instance;
    }



    public static void main(String[] args) {
        // 单线程 （main线程的操作动作。。。）
//        System.out.println(Code_004_Singleton.getInstance() == Code_004_Singleton.getInstance());
//        System.out.println(Code_004_Singleton.getInstance() == Code_004_Singleton.getInstance());
//        System.out.println(Code_004_Singleton.getInstance() == Code_004_Singleton.getInstance());

        // 并发多线程后，情况发生了很大的变化
        for (int i = 1; i <= 10; i++) {
            new Thread(() ->{
                Code_004_Singleton.getInstance();
            }, String.valueOf(i)).start();
        }
    }

}
