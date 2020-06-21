package javabase.Singleton;

public class LazySingleton {
    // 1 ����˽�л����췽��
    private LazySingleton() {
        System.out.println("����ʽ");
    }

    // 2 ��ʼ����ǰ��
    private static volatile LazySingleton instance = null;

    // 3 ������Ķ���
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
