package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:46
 *
 * 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第?i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class MaxProfitII {

    // 题目技巧
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0)
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    /**
     * 方法二：
     * 在第i次状态有
     *   1）第i次买入获得最大利润
     *       buy = max(buy, sell - price[i])
     *   2）第i次卖出获得最大利润
     *      sell = max(sell, buy + price[i])
     *
     * base case:
     * 第0次买入   buy = -price[0]
     *      卖出  sell = 0
     */

    public int maxProfit2(int[] prices) {
        if (prices.length < 1) return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, sell-prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
