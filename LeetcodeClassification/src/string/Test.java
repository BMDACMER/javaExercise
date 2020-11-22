package string;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/10/27 17:51
 */
public class Test {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
    }

    public static void test1() {
        String s1 = "1";
        String s2 = "1";

        String s = "1" + "1";
        String s3 = "11";

        System.out.println(s == s3);
        System.out.println("11".equals(s));
    }

    public static void test2() {
        String s1 = "1";
        String s2 = new String("1");

        String s = s1 + s2;
    }

    public static void test3() {
        String s1 = new String("guohao");
    }

    public static void test4() {
        String s = "guohao" + "xy";
    }

    public static void test5() {
        String s = "guohao" + "°®" + "xy";
    }

    public static void test6() {
        String str = "guohao" +  new String("°®xy");
    }
    public static void test7() {
        String str ="×ÓÑÀ" + new String("ÕæË§") + new String("666") + "111" + "222";
    }
}

























