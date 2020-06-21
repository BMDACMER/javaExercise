package javabase.Singleton;

/**
 * ����ʽ
 */
public class HungrySingleton {
    // 1 ˽�л��๹����
    private HungrySingleton() {
        System.out.println("����ʽ");
    }

    // 2 ������ǰ����󣬴˶������Ϊstatic
    private static volatile HungrySingleton hungrySingleton = new HungrySingleton();

    // 3 �ṩ�����ľ�̬������������Ķ���
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

}
