package 百度;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/3 19:46
 *
 * 第一题 数位
 * 要么为0 要么为 5
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            // 输入
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] res = new int[n];
            int count = 0;  // 统计5的个数
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 5)
                    count++;
            }

            int countZero = n - count;
            // 是9的倍数
            if (count % 9 == 0) {
                // 至少得有一个0 保证 整除90   将5全部移到左边
                if (count < n) {
                    int i;
                    for (i = 0; i < count; i++) {
                        res[i] = 5;
                    }

                    print(res, i, countZero);
                } else {
                    System.out.println("-1");
                }
            } else {
                // 找出离count最近的9的倍数
                int flag = 0;  // 标记 没找到
                for (int i = count - 1; i >= 9; --i) {
                    if (i % 9 == 0) {
                        int j = 0;
                        for (; j < i; j++) {
                            res[j] = 5;
                        }

                        print(res, j, countZero);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    System.out.println("-1");
            }

        }
    }

    private static void print(int[] res, int count,int countZero) {
        for (int i = 0; i < count; i++) {
            System.out.print(res[i]);
        }
        for (int i = 0; i < countZero; i++) {
            System.out.print("0");
        }
    }

}
