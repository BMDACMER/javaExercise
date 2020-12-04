package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/4 20:46
 *
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit_II {

    /**
     * 简洁版本
     * @param prices
     * @return
     */
 /*   public int maxProfit(int[] prices) {
        int res = 0;
        int temp;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                res += temp;
            }
        }

        return res;
    }*/

    /**
     * 动态规划版
     * 卖出：肯定是要得到钱  +money
     * 买入：肯定是付钱      -money
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profits = 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 初始化为0  相等于卖出
        dp[0][1] = -prices[0];   // 相等于买入

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);  // 此时的卖出值等于上一次的卖出后的值与当前进行卖出操作后的值 比较，取最大
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]); // 当前买入操作后的值等于 上一次买入后手里的值与 进行买入操作后剩余的值比较，取最大
        }

        profits = dp[prices.length - 1][0];  // 相当于卖出操作后手里的钱
        return profits;
    }

    public static void main(String[] args) {
        MaxProfit_II test = new MaxProfit_II();
        int[] prices = {1,2,6,4,7};
        System.out.println(test.maxProfit(prices));
    }
}
