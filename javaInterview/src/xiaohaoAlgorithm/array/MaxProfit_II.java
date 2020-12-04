package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/4 20:46
 *
 * 122. ������Ʊ�����ʱ�� II
 */
public class MaxProfit_II {

    /**
     * ���汾
     * @param prices
     * @return
     */
 /*   public int maxProfit(int[] prices) {
        int res = 0;
        int temp;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                res += temp;
            }
        }

        return res;
    }*/

    /**
     * ��̬�滮��
     * �������϶���Ҫ�õ�Ǯ  +money
     * ���룺�϶��Ǹ�Ǯ      -money
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profits = 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // ��ʼ��Ϊ0  ���������
        dp[0][1] = -prices[0];   // ���������

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);  // ��ʱ������ֵ������һ�ε��������ֵ�뵱ǰ���������������ֵ �Ƚϣ�ȡ���
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]); // ��ǰ����������ֵ���� ��һ������������ֵ�� �������������ʣ���ֵ�Ƚϣ�ȡ���
        }

        profits = dp[prices.length - 1][0];  // �൱�����������������Ǯ
        return profits;
    }

    public static void main(String[] args) {
        MaxProfit_II test = new MaxProfit_II();
        int[] prices = {1,2,6,4,7};
        System.out.println(test.maxProfit(prices));
    }
}
