package lintcode.stock;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/4 22:35
 * 122 买卖股票的最佳时机 II
 */
public class BuyStock2 {
    int interest = 0;
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0)
                interest += prices[i] - prices[i-1];

        }

        return interest;
    }
}
