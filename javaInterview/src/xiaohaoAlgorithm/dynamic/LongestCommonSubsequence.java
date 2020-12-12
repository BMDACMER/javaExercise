package xiaohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/12 10:31
 *
 * 1143. 最长公共子序列  LCS
 */
public class LongestCommonSubsequence {
    /**
     * dp[i][j] --- 表示str[0..i-1]与str[0..j-1]的最长公共子序列
     * dp[0][j] = 0 ---- ""与str[j-1]的最长子序列为"" 长度为0
     * dp[i][0] = 0 ---- str[i-1]与""的最长子序列为"" 长度为0
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 1 定义dp
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];   // 已经默认初始化为0了
        // 2 base case
        Arrays.fill(dp[0],0); // 此处可以省略
//        Arrays.fill(dp,0);

        // 3 状态转移方程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
