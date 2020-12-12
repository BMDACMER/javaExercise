package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/12 10:52
 * 72. 编辑距离
 */
public class MinDistance {
    /**
     * 思路：类似于LongestCommonSubsequence（LCS）
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        // 1 定义dp[][]
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 2 初始化 base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        // 3 状态转移方程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // 什么也不做
                } else {
                    dp[i][j] = min(dp[i][j-1] + 1, dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }
}
