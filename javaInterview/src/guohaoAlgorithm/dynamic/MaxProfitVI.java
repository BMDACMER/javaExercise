package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 12:57
 *
 * 309. 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第?i?个元素代表了第?i?天的股票价格 。?
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 */
public class MaxProfitVI {

    /**
     *根据题目描述，由于我们最多只能同时买入（持有）一支股票，并且卖出股票后有冷冻期的限制，因此我们会有三种不同的状态：
     * 1) 目前持有一只股票   对应的累计最大收益 记为 f[i][0]
     * 2) 目前不持有任何股票，并且处于冷冻期中，对应的累计最大收益为 f[i][1]
     * 3) 目前不持有任何股票，并且不处于冷静期  对应的累计最大收益为 f[i][2]
     *
     * 状态转移方程
     * f[i][0] = max(f[i-1][0], f[i-1][2] - price[i])
     * f[i][1] = f[i-1][0] + price[i]
     * f[i][2] = max(f[i-1][1], f[i-1][2])
     * base case:
     * f[0][0] = -price[0]
     * f[0][1] = 0
     * f[0][2] = 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;

        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] - prices[i]);
            f[i][1] = f[i][0] + prices[i];
            f[i][2] = Math.max(f[i-1][2], f[i-1][1]);
        }
        return Math.max(f[n-1][1], f[n-1][2]);
    }


    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;

        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; i++) {
            int tmp0 = Math.max(f0, f2 - prices[i]);
            int tmp1 = f0 + prices[i];
            int tmp2 = Math.max(f1, f2);

            f0 = tmp0;
            f1 = tmp1;
            f2 = tmp2;
        }

        return Math.max(f1, f2);
    }
}
