package lintcode.stock;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/5 11:55
 *
 * 309. 最佳买卖股票时机含冷冻期
 */
public class BuyStock5 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        /**
         * 初始化：
         * dp[0][0]=0;//本来就不持有，啥也没干
         * dp[0][1]=-1*prices[0];//第0天只买入
         * dp[0][2]=0;//可以理解成第0天买入又卖出，那么第0天就是“不持股且当天卖出了”这个状态了，其收益为0，所以初始化为0是合理的
         */
        int[][] dp = new int[prices.length][3];   // 三种状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
