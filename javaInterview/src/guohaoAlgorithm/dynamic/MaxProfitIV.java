package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:46
 *
 * 188. 买卖股票的最佳时机 IV  hard
 *
 * 给定一个整数数组?prices ，它的第 i 个元素?prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class MaxProfitIV {

    /**
     * 动态规划：
     * dp[i] --- 第i次交易获得的最大利润
     *------------------------------------
     *  buy[i] --- 表示第i次买入操作 获得的最大利润
     *  sell[i] --- 表示第i次卖出操作 获得的最大利润
     *
     * buy[i] = max(buy[i-1], sell[i-1] - price[i])
     * sell[i] = max(sell[i-1], buy[i-1] + price[i])
     *
     * base case:
     * buy[0] = -price[0]
     * sell[0] = 0
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        int n = prices.length;
        if (k > n/2) {
            return maxProfitII(prices, n);
        }

        int[] buy = new int[k];
        int[] sell = new int[k];
        buy[0] = -prices[0]; // 第一次买入所获得的最大利润
        sell[0] = 0;   // 第一次卖出所获得的最大利润
        for (int i = 0; i < k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return sell[k-1];
    }

    private int maxProfitII(int[] prices, int n) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i-1] > 0) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
