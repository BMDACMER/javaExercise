package lintcode.stock;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/5 10:27
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-gu-piao-de-zui-jia-shi-ji-iii-yi-kan-jiu-dong-/
 */
public class BuyStock3_2 {
    public static int maxProfit(int[] prices) {
        // ��ͼ۸�
        int minPrice = Integer.MAX_VALUE;
        // ��һ���������
        int maxProfit1 = Integer.MIN_VALUE;
        // �ڶ������������ʣ������
        int maxProfitAfterBuy = Integer.MIN_VALUE;
        // �����ܻ���������
        int maxProfit2 = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit1 = Math.max(maxProfit1,prices[i] - minPrice);
            maxProfitAfterBuy = Math.max(maxProfitAfterBuy, maxProfit1 - prices[i]);
            maxProfit2 = Math.max(maxProfit2, maxProfitAfterBuy + prices[i]);
        }

        return maxProfit2;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
}
