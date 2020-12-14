package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/14 14:42
 *
 * 1312. 让字符串成为回文串的最少插入次数
 */
public class MinInsertions {
    /**
     * dp[i][j] --- 子串s[i..j]的最小插入次数dp[i][j]
     * i==j 一个字符肯定符合回文数,所以dp[i][j]=0
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // 从后往前遍历
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
            }
        }

        return dp[0][n-1];
    }

    // 方法二 添加状态转移方程 进一步优化
    public int minInsertions2(String s) {
        int n = s.length();
        int[] dp = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j))
                    dp[j] = pre;
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                pre = temp;
            }
        }
        return dp[n - 1];
    }

}
