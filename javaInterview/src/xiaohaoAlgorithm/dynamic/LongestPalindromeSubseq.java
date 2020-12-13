package xiaohaoAlgorithm.dynamic;

import javabase.Array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/13 10:53
 * 516. 最长回文子序列
 */
public class LongestPalindromeSubseq {
    /**
     * dp[i][j] ---- 表示s[i,j]字串的最长回文长度
     * i <= j   如果i == j 最长当然为1啦，i<j 不存在  初始化为0
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 反着遍历
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        // 整个s的最长回文子序列长度
        return dp[0][n-1];
    }

    /**
     * 状态压缩
     */
    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = n-2; i >= 0; --i) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j))
                    dp[j] = pre + 2;
                else
                    dp[j] = Math.max(dp[j], dp[j-1]);
                pre = temp;
            }
        }
        return dp[n-1];
    }
}
