package juc.volatileTest;

public class HungrySingleton {
    //1.˽����Ĺ�����
    private HungrySingleton() {
        System.out.println("����ʽ");
    }

    //2.������ǰ�����,�˶���Ҳ��������Ϊstatic��
    private static volatile HungrySingleton instance = new HungrySingleton();

    //3.�ṩ�����ľ�̬�ķ�����������Ķ���
    public static HungrySingleton getInstance() {
        return instance;
    }
}
