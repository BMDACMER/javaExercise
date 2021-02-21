package guohaoAlgorithm.剑指offer;

/**
 * @Author guohao
 * @Date 2021/2/21 10:54
 * @Version 1.0
 *
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {

    /**
     * 自己写的动态规划   击败6.5%    完全仿造 最长递增子数组 模板
     * dp[i] --- 以nums[i]结尾的元素 获得的最大值
     * base case: dp[0] = 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int n = prices.length;
        int[] dp = new int[n];  // base case 全部为0
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] - prices[j] > 0) {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j]);
                }
            }
        }
        int ans = 0;
        for (int num : dp) {
            ans = Math.max(ans, num);
        }
        return ans;
    }

    // 三种状态

    /**
     * 1） 不操作
     * 2）只买不卖
     * 3） 正常操作
     * buy = max(buy, -price[i])
     * sell = max(sell, buy + price[i])
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
