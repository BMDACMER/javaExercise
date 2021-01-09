package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:29
 *
 * 123. 买卖股票的最佳时机 III  hard
 */
public class MaxProfitIII {

    /**
     * 算法思路：最多进行两次操作  能有五种状态
     * 1）未进行任何买卖操作
     * 2）进行一次买入操作
     * 3）进行一次买入、卖出，及完成一次买卖操作
     * 4）完成一次买卖操作后，在进行一次买入操作
     * 5）进行两次买卖操作
     *
     * 五种状态获得的最大利润分别为0，buy1,sell1,buy2,sell2
     * buy1 = max(buy1,0-price[i])
     * sell1 = max(sell1, buy1+price[i])
     * buy2 = max(buy2,sell1-price[i])
     * sell2 = max(sell2,buy2+price[i])
     *
     * 初始状态：第0天  buy1 = -price[0]
     *                sell1 = 0
     *                buy2 = -price[0]
     *                sell2 = 0
     *                因为每次每种状态保存的都是最大值，所以最终返回sell2结果即可
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;

        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1, buy1+prices[i]);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
