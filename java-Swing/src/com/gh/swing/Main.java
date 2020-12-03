package com.gh.swing;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/22 23:51
 */
public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        // 统计输入的各数字的重复次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }

        long res = 1;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            res *= A(entry.getValue(), entry.getValue());
        }

//        System.out.println(res % (Math.pow(10,9) + 7));

        System.out.printf("%d", (int)(res % (Math.pow(10,9) + 7)));
    }

    // 排列组合
    public static long A(int a, int b) {
        long sum = 1;
        int x = a;
        for (int i = 1; i <= b; i++) {
            sum *= x;
            x--;
        }

        return sum;
        */

        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        a[1] = "balbal";
        b[1] = Integer.valueOf(42);
//        b[1] = "qqqqq";
        System.out.println("a的地址为" + a + "\t a[0] = " + a[0] + "\t a[1] = " + a[1] + "\nb的地址 " + b + "b[1] = " + b[1]);
    }

}
