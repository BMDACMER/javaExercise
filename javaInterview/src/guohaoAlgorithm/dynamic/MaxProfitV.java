package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 12:39
 *
 * 714. 买卖股票的最佳时机含手续费
 *
 * 给定一个整数数组?prices，其中第?i?个元素代表了第?i?天的股票价格 ；非负整数?fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 */
public class MaxProfitV {

    /**
     * buy = -price[0];
     * sell = 0-fee;
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 1) return 0;
        int n = prices.length;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell,buy + prices[i] - fee);
        }

        return sell;
    }

    public static void main(String[] args) {
        int[] price = {1, 3, 2, 8, 4, 9};
        MaxProfitV m = new MaxProfitV();

        System.out.println(m.maxProfit(price, 2));
    }
}
