package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/4 21:12
 * 121. ������Ʊ�����ʱ��
 *
 * ֻ�������һ��
 */
public class MaxProfit_I {

    /**
     * ����������Ϊһ�β����������������һ�β�����
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int minPrice = Integer.MAX_VALUE;
        int totalProfit = Integer.MIN_VALUE;  // ��ʼ��Ϊ��С

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            totalProfit = Math.max(totalProfit, prices[i] - minPrice);
        }

        return totalProfit;
    }
}
