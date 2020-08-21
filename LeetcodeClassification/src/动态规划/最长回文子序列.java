package 动态规划;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 15:15
 *
 * 516. 最长回文子序列
 *  最长回文子序列 可以是 非连续的
 *
 */
public class 最长回文子序列 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // 1) 定义dp[i][j]: 表示从第i个索引为止的元素到第j个元素的 子序列
        int[][] dp = new int[n][n];

        // 如果只有一个字符，显然最长回文子序列长度是 1，也就是 dp[i][j] = 1 (i == j)
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        // i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
        for (int i = n - 1; i >= 0; --i) {
       //     dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        //  整个 s 的最长回文子串长度
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        最长回文子序列 m = new 最长回文子序列();
        System.out.println(m.longestPalindromeSubseq("bbbbb"));
    }
}
