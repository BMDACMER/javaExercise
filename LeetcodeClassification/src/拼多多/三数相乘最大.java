package 拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 13:58
 *
 * 已经无序数组，由正数、负数和0三部分组成，找出三个数使得乘积最大。
 */
public class 三数相乘最大 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();   // 输入的元素长度
        if (n <= 2)
            System.out.println("0");
        else {
            int max = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            // 算法关键点   找出排好序的后三位 或者 位于首两位与最后一位的乘积
            int a = arr[n-3] * arr[n-2] * arr[n-1];
            int b = arr[0] * arr[1] * arr[n-1];
            max = a > b ? a : b;
            System.out.println(max);
        }


    }
}
