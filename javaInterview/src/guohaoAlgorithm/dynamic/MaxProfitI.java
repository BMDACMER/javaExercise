package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:46
 *
 * 121. ������Ʊ�����ʱ��
 *
 * ����һ�����飬���ĵ�?i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 *
 * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊһ�Σ������һ���㷨�����������ܻ�ȡ���������
 *
 * ע�⣺�㲻���������Ʊǰ������Ʊ��
 */
public class MaxProfitI {

    /**
     * ˼·�����ֻ���һ�ʽ���  ������״̬
     * 1���������������
     * 2��ֻ������
     * 3���������  �����һ����������
     *
     * �ֱ��õĵ��������Ϊ0��buy�� sell
     * ״̬ת�Ʒ���Ϊ��
     * buy = max(buy, -price[i])
     * sell = max(sell,buy+price[i])
     * ����sell����
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }

    // ��������
    public int maxProfit2(int[] prices) {
        if (prices.length < 1) return 0;

        int profit = 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (profit < prices[i] - start) {
                profit = prices[i] - start;
            }
            if (prices[i] > start) {
                start = prices[i];
            }
        }
        return profit;
    }
}
