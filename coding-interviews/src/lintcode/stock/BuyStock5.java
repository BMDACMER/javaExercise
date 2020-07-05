package lintcode.stock;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/5 11:55
 *
 * 309. ���������Ʊʱ�����䶳��
 */
public class BuyStock5 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        /**
         * ��ʼ����
         * dp[0][0]=0;//�����Ͳ����У�ɶҲû��
         * dp[0][1]=-1*prices[0];//��0��ֻ����
         * dp[0][2]=0;//�������ɵ�0����������������ô��0����ǡ����ֹ��ҵ��������ˡ����״̬�ˣ�������Ϊ0�����Գ�ʼ��Ϊ0�Ǻ����
         */
        int[][] dp = new int[prices.length][3];   // ����״̬
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
