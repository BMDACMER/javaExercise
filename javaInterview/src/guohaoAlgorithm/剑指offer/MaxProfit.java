package guohaoAlgorithm.��ָoffer;

/**
 * @Author guohao
 * @Date 2021/2/21 10:54
 * @Version 1.0
 *
 * ��ָ Offer 63. ��Ʊ���������
 * �����ĳ��Ʊ�ļ۸���ʱ���Ⱥ�˳��洢�������У����������ù�Ʊһ�ο��ܻ�õ���������Ƕ��٣�
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: [7,1,5,3,6,4]
 * ���: 5
 * ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
 *      ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
 * ʾ�� 2:
 *
 * ����: [7,6,4,3,1]
 * ���: 0
 * ����: �����������, û�н������, �����������Ϊ 0��
 */
public class MaxProfit {

    /**
     * �Լ�д�Ķ�̬�滮   ����6.5%    ��ȫ���� ����������� ģ��
     * dp[i] --- ��nums[i]��β��Ԫ�� ��õ����ֵ
     * base case: dp[0] = 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int n = prices.length;
        int[] dp = new int[n];  // base case ȫ��Ϊ0
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] - prices[j] > 0) {
                    dp[i] = Math.max(dp[i], prices[i] - prices[j]);
                }
            }
        }
        int ans = 0;
        for (int num : dp) {
            ans = Math.max(ans, num);
        }
        return ans;
    }

    // ����״̬

    /**
     * 1�� ������
     * 2��ֻ����
     * 3�� ��������
     * buy = max(buy, -price[i])
     * sell = max(sell, buy + price[i])
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
