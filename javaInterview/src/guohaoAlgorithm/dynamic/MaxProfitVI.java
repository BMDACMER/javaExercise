package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/9 12:57
 *
 * 309. ���������Ʊʱ�����䶳��
 *
 * ����һ���������飬���е�?i?��Ԫ�ش����˵�?i?��Ĺ�Ʊ�۸� ��?
 *
 * ���һ���㷨����������������������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��:
 *
 * �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * ������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
 *
 */
public class MaxProfitVI {

    /**
     *������Ŀ�����������������ֻ��ͬʱ���루���У�һ֧��Ʊ������������Ʊ�����䶳�ڵ����ƣ�������ǻ������ֲ�ͬ��״̬��
     * 1) Ŀǰ����һֻ��Ʊ   ��Ӧ���ۼ�������� ��Ϊ f[i][0]
     * 2) Ŀǰ�������κι�Ʊ�����Ҵ����䶳���У���Ӧ���ۼ��������Ϊ f[i][1]
     * 3) Ŀǰ�������κι�Ʊ�����Ҳ������侲��  ��Ӧ���ۼ��������Ϊ f[i][2]
     *
     * ״̬ת�Ʒ���
     * f[i][0] = max(f[i-1][0], f[i-1][2] - price[i])
     * f[i][1] = f[i-1][0] + price[i]
     * f[i][2] = max(f[i-1][1], f[i-1][2])
     * base case:
     * f[0][0] = -price[0]
     * f[0][1] = 0
     * f[0][2] = 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;

        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] - prices[i]);
            f[i][1] = f[i][0] + prices[i];
            f[i][2] = Math.max(f[i-1][2], f[i-1][1]);
        }
        return Math.max(f[n-1][1], f[n-1][2]);
    }


    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;

        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; i++) {
            int tmp0 = Math.max(f0, f2 - prices[i]);
            int tmp1 = f0 + prices[i];
            int tmp2 = Math.max(f1, f2);

            f0 = tmp0;
            f1 = tmp1;
            f2 = tmp2;
        }

        return Math.max(f1, f2);
    }
}
