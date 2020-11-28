package com.gh.swing;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/28 15:49
 */
public class Test {
    public static void main(String[] args) {
        /*Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);  // true
        System.out.println(e == f);  // false
        System.out.println(c == (a + b));  // true
        System.out.println(c.equals(a + b));  // true
        System.out.println(g == (a + b));     // true
        System.out.println(g.equals(a + b));  // false*/

        /**
         * Java-Integer缓存机制
         * 参考：https://blog.csdn.net/m0_37524661/article/details/88203938
         *
         * 为了节省内存，提高性能，当取值区间在 -128~127 时，变量a和b会共用一个对象，即直接将a的内存地址赋给b
         *
         * 如果，不在 -128~127 这个区间，则会分别创建两个对象，如e和f就指向两个不同的对象，这就是Integer的缓存机制
         *
         * 且这种机制只在自动装箱时有效，如果用 Integer a = new Integer(10);这种方式则无效
         */

        Integer a = 10;
        Integer b = 10;
        System.out.println("a == b: " + (a == b));  // true

        Integer c = 100;
        Integer d = 100;
        System.out.println("c == d: " + (c == d));  // true

        Integer e = 128;
        Integer f = 128;
        System.out.println("e == f: " + (e == f)); // false

        Integer u = new Integer(10);
        Integer i = 10;
        System.out.println("u == i: " + (u == i));  // false

        int j = 10;
        Integer k = 10;
        System.out.println("j == k: " + (j == k)); // true

    }
}
