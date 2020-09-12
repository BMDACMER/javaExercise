package ÌìÒíÔÆ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/9 21:33
 * 1 ³óÊı
 */
public class Main {
    static int[] nums = new int[1501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int res = choushu(n);
            System.out.println(res);
        }
    }

    /**
     * ÅĞ¶Ï³óÊı
     * @param n
     * @return
     */
    private static int choushu(int n) {
        int index = 1;
        for (int i = 1; i <= 1500; i++) {
            if (isChouShu(i)) {
                nums[index++] = i;
            }
        }
        int res = nums[n];
        return res;
    }

    public static boolean isChouShu(int n) {
        if (n == 1 || n == 2 || n == 3 || n == 5)
            return true;

        Set<Integer> set = new HashSet<>();

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                set.add(i);
                if (i != 2 && i != 3 && i != 5) {
                    if (i % 2 == 0 || i%3==0 || i%5==0)
                        set.remove(i);
                }
            }
        }

        if (set.size() > 0) {
            // ÅĞ¶Ï³óÊı
            set.remove(2);
            set.remove(3);
            set.remove(5);
            return set.size() == 0;
        }

        return false;
    }
}
