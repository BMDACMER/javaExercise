package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 21:19
 *
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class Change {

    public int change(int amount, int[] coins) {
        /**
         * dp[i][amount]: 前i个数 凑成amount金额 总共的方法
         * dp[0][amount] = 0, dp[i][0] = 1 // 因为不使用任何硬币面试，无法凑出硬币
         *
         * dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
         */
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {// i从0开始可以避免空数组情况
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    // 状态压缩： 完全背包问题  内层循环从小到达  0-1背包问题 内循环从大到小
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
}
