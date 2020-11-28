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
         * Java-Integer�������
         * �ο���https://blog.csdn.net/m0_37524661/article/details/88203938
         *
         * Ϊ�˽�ʡ�ڴ棬������ܣ���ȡֵ������ -128~127 ʱ������a��b�Ṳ��һ�����󣬼�ֱ�ӽ�a���ڴ��ַ����b
         *
         * ��������� -128~127 ������䣬���ֱ𴴽�����������e��f��ָ��������ͬ�Ķ��������Integer�Ļ������
         *
         * �����ֻ���ֻ���Զ�װ��ʱ��Ч������� Integer a = new Integer(10);���ַ�ʽ����Ч
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
