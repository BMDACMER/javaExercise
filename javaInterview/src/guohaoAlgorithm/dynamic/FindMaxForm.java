package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 21:54
 *
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，
 * 因为它含 4 个 1 ，大于 n 的值 3 。
 */
public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        /**
         * dp[i][m][n] : 前i个字符串中满足m，n的最大子集
         *
         * base case:  都为零
         *
         */
        int len = strs.length;
        int[][][] dp = new int[len + 1][m+1][n+1];

        for (int i = 1; i <= len; i++) {
            // 统计strs[i]中 0 和 1的个数
            int count = 0;   // 统计0的个数
            for (int j = 0; j < strs[i - 1].length(); j++) {
                if (strs[i - 1].charAt(j) == '0')
                    count++;
            }
            int count2 = strs[i - 1].length() - count;  // 统计1的个数

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j - count >= 0 && k - count2 >= 0) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i - 1][j - count][k - count2] + 1);
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }

        return dp[len][m][n];
    }

    // 优化  状态转移方程
    public int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= len; i++) {
            // 统计strs[i]中 0 和 1的个数
            int count = 0;   // 统计0的个数
            for (int j = 0; j < strs[i - 1].length(); j++) {
                if (strs[i - 1].charAt(j) == '0')
                    count++;
            }
            int count2 = strs[i - 1].length() - count;  // 统计1的个数

            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j - count >= 0 && k - count2 >= 0) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - count][k - count2] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }

}
