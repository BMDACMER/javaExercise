package lintcode.stock;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/5 12:57
 *
 * 714. 买卖股票的最佳时机含手续费
 */
public class BuyStock6 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0) return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < len; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i] - fee);
        }
        return sell;
    }
}
