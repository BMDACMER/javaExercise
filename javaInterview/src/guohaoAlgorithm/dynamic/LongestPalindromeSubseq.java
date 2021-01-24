package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 20:45
 *
 * 516. 最长回文子序列
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromeSubseq {

    /**
     * 输入:
     *
     * "bbbab"
     * 输出:
     *
     * 4
     * 一个可能的最长回文子序列为 "bbbb"。
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        // 与最小插入子序列 类似
        /**
         * dp[i][j]----s[i,j]最长回文子序列
         * d[i][i] = 1
         * if (s[i]== s[j]) dp[i][j] = dp[i+1][j-1] + 2;
         * else dp[i][j] = max(dp[i+1][j], dp[i][j-1])
         */
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }

    // 优化 --->  降维   参考：P145
    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n-2; i >= 0; --i) {
            // 存储dp[i+1][j-1]变量
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j))
                    // dp[i][j] = dp[i+1][j-1]+2
                    dp[j] = pre + 2;
                else dp[j] = Math.max(dp[j], dp[j - 1]);

                pre = temp;
            }
        }
        return dp[n-1];
    }
}
