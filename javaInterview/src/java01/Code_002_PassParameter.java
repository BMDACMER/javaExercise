package java01;

public class Code_002_PassParameter {

    // ֵ����
    public static void testPassParameter(StringBuffer ss1){
        ss1 = new StringBuffer("World");
    }

    // ֵ����+���ô���
    public static void testPassParameter2(StringBuffer ss1, int n){
        ss1.append(" World");
        n = 8;
    }

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer("Hello");
        StringBuffer s2 = new StringBuffer("Hello");
        int i = 1;
        testPassParameter(s1);
        testPassParameter2(s2,i);
        System.out.println("1 ���� ֵ���� " + s1);
        System.out.println("2 ���� ֵ����+���ô��� " + s2);
    }

}

