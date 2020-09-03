package 拼多多;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 19:06
 * 1 多多的n阶矩阵
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] nums = new int[n][n];

            // 找规律
            nums[0][1] = 2;
            nums[0][n-2] = 1;
            nums[1][0] = 3;
            nums[1][n-1] = 8;
            nums[n-2][0] = 4;
            nums[n-2][n-1] = 7;
            nums[n-1][1] = 5;
            nums[n-1][n-2] = 6;

            // 输出
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
