package java01;

import org.junit.Test;

/**
 * �������
 */
public class Code_007_Reflect {
    public static void main(String[] args) {
        Class<?> c = A.class;
        System.out.println("className:" + c.getName());  // className:java01.A

    }

    @Test
    public void test1(){
        Class<?> c = null;

        try {
            // java01.A  ������module�µ�ȫ��
            c = Class.forName("java01.A");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("className:" + c.getName());
        // ������Ϊ��
        //static block
        //className:java01.A
    }

    @Test
    public void test2(){
        Class<?> c = new A().getClass();
        System.out.println("className:" + c.getName());
        // ������Ϊ��
        //static block
        //className:java01.A
    }

}


class A{
    static {
        System.out.println("static block");
    }

}

