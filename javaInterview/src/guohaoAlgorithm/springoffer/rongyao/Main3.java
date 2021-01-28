package guohaoAlgorithm.springoffer.rongyao;

import guohaoAlgorithm.dynamic.LongestCommonSubsequence;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 12:24
 *
 * 最大子序列
 * 输入：
 *  1  2  3  4
 *  2  3  1  4
 * 输出：3
 * 原因：去掉1，剩余均为  2  3  4
 * 1
 * 2
 * 3
 * 4
 * 5
 * 两数字序列，去掉部分数字后使剩余数字序列相同，求剩余最大数
 */
public class Main3 {

    /**
     * 套路就是 最大公共子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // base case 都为零
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String text1 = scan.next();
            String text2 = scan.next();
            int res = l.longestCommonSubsequence(text1, text2);
            System.out.println(res);
        }
    }
}
