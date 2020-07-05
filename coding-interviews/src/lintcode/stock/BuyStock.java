package lintcode.stock;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/4 22:18
 * 121 买卖股票的最佳时机
 */
public class BuyStock {
    /**
    int interest = 0;
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (interest < prices[i] - start) {
                interest = prices[i] - start;
            }
            if (start > prices[i])
                start = prices[i];
        }
        return interest;
    }
     */

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int totalProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            totalProfit = Math.max(totalProfit,prices[i] - minPrice);
        }
        return totalProfit;
    }
}
