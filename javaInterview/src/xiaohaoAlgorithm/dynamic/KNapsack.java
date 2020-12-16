package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 14:00
 *  01��������    P191
 */
public class KNapsack {
    /**
     * dp[i][w] --- ���ڵ�ǰi����Ʒ����ǰ����������Ϊwʱ����������¿���װ�µ�����ֵ��dp[i][w]
     * @param W
     * @param N
     * @param wt
     * @param val
     * @return
     */
    public int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[W + 1][N + 1];

        for (int i = 1; i < N; i++) {
            for (int w = 1; w < W; w++) {
                if (w - wt[i - 1] >= 0) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                } else {
                    // װ������
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[N][W];
    }
}
