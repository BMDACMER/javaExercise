package juc.volatileTest;

public class LazySingleton {
    // 1 ˽�л�������
    private LazySingleton() {
        System.out.println("����ʽ");
    }

    // 2 ������̬��˽�л���ʵ������
    private static volatile LazySingleton instance = null;

    // 3 ������̬ʵ��
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
