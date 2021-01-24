package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 21:06
 *
 * 1312. 让字符串成为回文串的最少插入次数
 *
 * https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */
public class MinInsertions {

    /**
     * 输入：s = "mbadm"
     * 输出：2
     * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        /*
        dp[i][j] --- 表示变成回文串s[i,j]需要插入的最少次数
        if(s[i] == s[j])  dp[i][j] = dp[i+1,j-1];
        else dp[i][j] = min(dp[i][j-1], dp[i+1][j]) + 1;

        base case :  i<=j  如果i>j 不合法 请忽略   dp[i][i] = 0;
        需要倒序遍历   （从左到右从下到上）
         */
        if (s == null || "".equals(s)) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
                }
            }
        }
        return dp[0][n-1];
    }

}
