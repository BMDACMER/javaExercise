package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 12:39
 *
 * 714. ������Ʊ�����ʱ����������
 *
 * ����һ����������?prices�����е�?i?��Ԫ�ش����˵�?i?��Ĺ�Ʊ�۸� ���Ǹ�����?fee �����˽��׹�Ʊ���������á�
 *
 * ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 *
 * ���ػ����������ֵ��
 */
public class MaxProfitV {

    /**
     * buy = -price[0];
     * sell = 0-fee;
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 1) return 0;
        int n = prices.length;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell,buy + prices[i] - fee);
        }

        return sell;
    }

    public static void main(String[] args) {
        int[] price = {1, 3, 2, 8, 4, 9};
        MaxProfitV m = new MaxProfitV();

        System.out.println(m.maxProfit(price, 2));
    }
}
