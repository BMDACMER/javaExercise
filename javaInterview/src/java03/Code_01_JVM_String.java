package java03;

import org.junit.Test;

/**
 * �Ƚ��ַ����������ڴ�����е��ַ���
 */
public class Code_01_JVM_String {
    public static void main(String[] args) {
        String s1 = new String("a");
        s1.intern();
        String s2 = "a";
        System.out.println(s1 == s2);  // false

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);  // true
    }

    // ���ϴ���ߵ�˳��
    @Test
    public void test(){
        String s2 = new String("a") + "b";
        s2.intern();
        String s1 = "a" + "b";
        System.out.println(s1 == s2); // true

        String s3 = new String("a") + new String("a");
        String s4 = "aa";
        s3.intern();   //  ���ڡ�aa���Ѿ�����  �������벢����������
        System.out.println(s3 == s4);    // false

    }
}
