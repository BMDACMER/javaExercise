package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 23:48
 *
 * 剑指 Offer 63. 股票的最大利润
 *
 * 与 MaxProfitI 一样  easy
 */
public class MaxProfitVII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int start = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - start > 0) {
                profit += prices[i] - start;
            }
            if (prices[i] < start) {
                start = prices[i];
            }
        }
        return profit;
    }
}
