package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/28 8:24
 * 188. 买卖股票的最佳时机 IV
 */
public class BuyStocksHard {
    /**
     * dp[i][2] --表示前i次操作（买入/卖出）所获得的最大利润
     * 其中 0---买入   1---卖出
     * base case：
     * dp[0][0] = -prices[0]  // 表示第一次买入所获得的最大利润
     * dp[0][1] = 0   // 第一次卖出所获得最大利润
     * 状态转移方程
     * dp[i][0] = max(dp[i-1][1]-prices[i], dp[i-1][0])
     * dp[i][1] = max(dp[i-1][0]+prices[i], dp[i-1][1])
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k < 1 ) { return 0; }

        // k 超过了上限，也就变成了 无限次交易问题
        if (k > prices.length / 2) {
            return maxProfitOfII(prices);
        }


        int[][] profit = new int[k][2];
        // 初始化  base case
        for (int i = 0; i < k; i++) {
            profit[i][0] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < prices.length; i++) {
            profit[0][0] = Math.max(profit[0][0], -prices[i]);
            profit[0][1] = Math.max(profit[0][1], profit[0][0] + prices[i]);

            for (int j = 1; j < k; j++) {
                profit[j][0] = Math.max(profit[j-1][1]-prices[i], profit[j][0]);
                profit[j][1] = Math.max(profit[j][0]+prices[i], profit[j][1]);
            }
        }
        // 抛出股票 返回最大值
        return profit[k-1][1];
    }

    // 解决无限次交易的方法
    public int maxProfitOfII(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
