package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/17 14:36
 */
public class StockProfit {

    /**
     * dp[i][0] --- ��i����л�õ�����������룩
     * dp[i][1] --- ��i�첻���л�õ��������(����)
     * dp[0][0] = -prices[0]
     * dp[0][1] = 0
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1]-price[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0]+price[i]-free)
     */
    public int maxProfit(int[] prices, int free) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - free);
        }

        return dp[n-1][1];
    }

    /**
     * �Ż���ѹ��״̬
     */
    public int maxProfit2(int[] prices, int free) {
        int n = prices.length;
        int[] dp = new int[2];

        dp[0] = -prices[0];   // ����
        dp[1] = 0;            // ����

        for (int i = 1; i < n; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1]-prices[i]);
            dp[1] = Math.max(dp[1], tmp + prices[i] - free);
        }

        return dp[1];
    }

}
