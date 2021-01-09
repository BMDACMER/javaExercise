package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 9:29
 *
 * 123. ������Ʊ�����ʱ�� III  hard
 */
public class MaxProfitIII {

    /**
     * �㷨˼·�����������β���  ��������״̬
     * 1��δ�����κ���������
     * 2������һ���������
     * 3������һ�����롢�����������һ����������
     * 4�����һ�������������ڽ���һ���������
     * 5������������������
     *
     * ����״̬��õ��������ֱ�Ϊ0��buy1,sell1,buy2,sell2
     * buy1 = max(buy1,0-price[i])
     * sell1 = max(sell1, buy1+price[i])
     * buy2 = max(buy2,sell1-price[i])
     * sell2 = max(sell2,buy2+price[i])
     *
     * ��ʼ״̬����0��  buy1 = -price[0]
     *                sell1 = 0
     *                buy2 = -price[0]
     *                sell2 = 0
     *                ��Ϊÿ��ÿ��״̬����Ķ������ֵ���������շ���sell2�������
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;

        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1, buy1+prices[i]);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
