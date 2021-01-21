package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 19:16
 *
 * 322. 零钱兑换
 */
public class CoinChange {

    /*// 方法一： dp
    public int coinChange(int[] coins, int amount) {
        // dp[n] --- 凑出金额n 所需要的最少coins
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // base case     凑出0元需要0枚硬币
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }*/

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {1,5,2};
        System.out.println(c.coinChange(coins, 11));
    }


    // 方法二： 贪心算法+dfs
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0 || amount == 0) return 0;
        Arrays.sort(coins);
        int count = 0;
        dfs(coins, amount, n - 1, count);
        return res==Integer.MAX_VALUE? -1:res;
    }

    private void dfs(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }

        if(index<0){
            return;
        }

        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            dfs(coins, amount - i * coins[index], index - 1, count + i);
        }
    }
}
