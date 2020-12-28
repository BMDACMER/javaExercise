package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/28 8:24
 * 188. ������Ʊ�����ʱ�� IV
 */
public class BuyStocksHard {
    /**
     * dp[i][2] --��ʾǰi�β���������/����������õ��������
     * ���� 0---����   1---����
     * base case��
     * dp[0][0] = -prices[0]  // ��ʾ��һ����������õ��������
     * dp[0][1] = 0   // ��һ������������������
     * ״̬ת�Ʒ���
     * dp[i][0] = max(dp[i-1][1]-prices[i], dp[i-1][0])
     * dp[i][1] = max(dp[i-1][0]+prices[i], dp[i-1][1])
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k < 1 ) { return 0; }

        // k ���������ޣ�Ҳ�ͱ���� ���޴ν�������
        if (k > prices.length / 2) {
            return maxProfitOfII(prices);
        }


        int[][] profit = new int[k][2];
        // ��ʼ��  base case
        for (int i = 0; i < k; i++) {
            profit[i][0] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < prices.length; i++) {
            profit[0][0] = Math.max(profit[0][0], -prices[i]);
            profit[0][1] = Math.max(profit[0][1], profit[0][0] + prices[i]);

            for (int j = 1; j < k; j++) {
                profit[j][0] = Math.max(profit[j-1][1]-prices[i], profit[j][0]);
                profit[j][1] = Math.max(profit[j][0]+prices[i], profit[j][1]);
            }
        }
        // �׳���Ʊ �������ֵ
        return profit[k-1][1];
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
