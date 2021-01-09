package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:46
 *
 * 122. ������Ʊ�����ʱ�� II
 *
 * ����һ�����飬���ĵ�?i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 *
 * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
 *
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 *
 */
public class MaxProfitII {

    // ��Ŀ����
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0)
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    /**
     * ��������
     * �ڵ�i��״̬��
     *   1����i���������������
     *       buy = max(buy, sell - price[i])
     *   2����i����������������
     *      sell = max(sell, buy + price[i])
     *
     * base case:
     * ��0������   buy = -price[0]
     *      ����  sell = 0
     */

    public int maxProfit2(int[] prices) {
        if (prices.length < 1) return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, sell-prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
