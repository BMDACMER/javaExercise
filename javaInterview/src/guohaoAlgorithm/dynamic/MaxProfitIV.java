package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:46
 *
 * 188. ������Ʊ�����ʱ�� IV  hard
 *
 * ����һ����������?prices �����ĵ� i ��Ԫ��?prices[i] ��һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 *
 * ���һ���㷨�����������ܻ�ȡ�������������������� k �ʽ��ס�
 *
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ��
 */
public class MaxProfitIV {

    /**
     * ��̬�滮��
     * dp[i] --- ��i�ν��׻�õ��������
     *------------------------------------
     *  buy[i] --- ��ʾ��i��������� ��õ��������
     *  sell[i] --- ��ʾ��i���������� ��õ��������
     *
     * buy[i] = max(buy[i-1], sell[i-1] - price[i])
     * sell[i] = max(sell[i-1], buy[i-1] + price[i])
     *
     * base case:
     * buy[0] = -price[0]
     * sell[0] = 0
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        int n = prices.length;
        if (k > n/2) {
            return maxProfitII(prices, n);
        }

        int[] buy = new int[k];
        int[] sell = new int[k];
        buy[0] = -prices[0]; // ��һ����������õ��������
        sell[0] = 0;   // ��һ����������õ��������
        for (int i = 0; i < k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return sell[k-1];
    }

    private int maxProfitII(int[] prices, int n) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i-1] > 0) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
