package guohaoAlgorithm.math;

import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 15:03
 *
 * 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 */
public class SuperPow {

    /**
     * 思想：分为奇数和偶数  递归调用即可
     * @param a
     * @param b
     * @return
     */
    private int base = 1337;
    public int superPow(int a, int[] b) {
        if (b ==null || b.length < 1) return 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < b.length; i++) {
            list.add(b[i]);
        }

        return help(a, list);
    }

    private int help(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) return 1;

        int last = list.removeLast();
        int part1 = myPow(a, last);
        int part2 = myPow(help(a, list), 10);
        // 每次相乘都要求莫
        return (part1 * part2) % base;
    }

    private int myPow(int a, int k) {
        if (k == 0) return 1;
        a %= base;

        if (k % 2 == 1) {
            return (a * myPow(a, k - 1)) % base;
        } else {
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
