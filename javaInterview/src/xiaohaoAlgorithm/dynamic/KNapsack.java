package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 14:00
 *  01背包问题    P191
 */
public class KNapsack {
    /**
     * dp[i][w] --- 对于当前i个物品，当前背包的容量为w时，这种情况下可以装下的最大价值是dp[i][w]
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
                    // 装不下了
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[N][W];
    }
}
