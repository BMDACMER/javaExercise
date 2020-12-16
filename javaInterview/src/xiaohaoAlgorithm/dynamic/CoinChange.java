package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 14:38
 *
 * 322. 零钱兑换
 */
public class CoinChange {

    /**
     * dp[i][j] --- 若只是用前i个物品，当背包容量为j时，有dp[i][j]中方案可以装满背包
     * base case:  dp[0][..] = 0, dp[..][0] = 1; 因为如果不适用任何硬币面值，就无法凑出任何金额，如果凑出的目标
     * 金额为0，那么“无为而治”就是唯一一种方法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case:
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int n= coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0)
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
