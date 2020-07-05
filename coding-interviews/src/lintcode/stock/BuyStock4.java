package lintcode.stock;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/5 11:09
 *
 * 188. ������Ʊ�����ʱ�� IV
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell
 * -stock-iv/solution/mai-gu-piao-de-zui-jia-shi-ji-iv-zui-duo-k-ci-jiao/
 */
public class BuyStock4 {
    public int maxProfit(int k, int[] prices) {
        if (k < 1 ) { return 0; }

        // k ���������ޣ�Ҳ�ͱ���� ���޴ν�������
        if (k > prices.length / 2) {
            return maxProfitOfII(prices);
        }


        int[][] dp = new int[k][2];   // ����״̬ 0--����   1--����
        // ��ʼ��
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }

        // ����ÿһ��ģ��k�ν��ף����㲢����״̬
        for (int p : prices) {
            dp[0][0] = Math.max(dp[0][0], -p);           // ��һ����
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + p);   // ��һ����

            for (int i = 1; i < k; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i-1][1] - p);  // ��i����
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + p);   // �� i ����
            }
        }
        return dp[k-1][1];
    }

    // ������޴ν��׵ķ���
    public int maxProfitOfII(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
