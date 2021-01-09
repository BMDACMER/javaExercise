package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:46
 *
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第?i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 */
public class MaxProfitI {

    /**
     * 思路：最多只完成一笔交易  有三种状态
     * 1）不进行如何买卖
     * 2）只卖不买
     * 3）先买后卖  即完成一次买卖操作
     *
     * 分别获得的的最大利润为0，buy， sell
     * 状态转移方程为：
     * buy = max(buy, -price[i])
     * sell = max(sell,buy+price[i])
     * 返回sell即可
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }

    // 方法二：
    public int maxProfit2(int[] prices) {
        if (prices.length < 1) return 0;

        int profit = 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (profit < prices[i] - start) {
                profit = prices[i] - start;
            }
            if (prices[i] > start) {
                start = prices[i];
            }
        }
        return profit;
    }
}
