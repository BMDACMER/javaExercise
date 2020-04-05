package juc.base;

import java.util.ArrayList;

/**
 * 1 ����ʽ���
 * 2 @FunctionalInterface
 * 3 default
 * 4 static
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        // �ӿڿ��Դ�������
//        Foo foo = new Foo(){
//
//
//
//            @Override
//            public void sayHello() {
//                System.out.println("*********hello123");
//            }
//        };
//        foo.sayHello();

        Foo foo1 = (int x, int y) -> {
            return x + y;
        };
        System.out.println(foo1.add(1, 2));
        System.out.println(foo1.mul(3,5));
        System.out.println(Foo.mul2(5,6));
    }

}

interface Foo{
//    public abstract void sayHello();
    public int add(int a, int b);
    // �����ж��Ĭ�Ϸ���
    public default  int mul(int x, int y) {
        return x * y;
    }
    // ���Զ�������̬����
    public static int mul2(int x, int y) {
        return x * y;
    }

    public static void main1(String[] args) {
        ArrayList arrayList = new ArrayList();
    }
}