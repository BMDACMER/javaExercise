package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/4 21:12
 * 121. 买卖股票的最佳时机
 *
 * 只允许操作一次
 */
public class MaxProfit_I {

    /**
     * 买入与卖出为一次操作，本次最多允许一次操作。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int minPrice = Integer.MAX_VALUE;
        int totalProfit = Integer.MIN_VALUE;  // 初始化为最小

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            totalProfit = Math.max(totalProfit, prices[i] - minPrice);
        }

        return totalProfit;
    }
}
