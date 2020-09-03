package 拼多多;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 20:10
 * 2 多多的背包问题
 *
 * N --- 商品的总数
 * M --- 背包的原始大小
 *
 * ci -- 第i件商品占用的背包空间
 * vi -- 第i件商品的收益
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[][] nums = new int[n][2];
            int res = 0;
            int sum;

            for (int i = 0; i < n; i++) {
                nums[i][0] = scan.nextInt();
                nums[i][1] = scan.nextInt();

                // 占空间无收益的 直接pass
                if (nums[i][0] > 0 && nums[i][1] < 0);
            }

        }
    }
}
