package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 10:41
 *
 * 887. 鸡蛋掉落
 * https://leetcode-cn.com/problems/super-egg-drop/
 */
public class SuperEggDrop {

    public int superEggDrop(int K, int N) {
        /**
         * dp[k][m] = n
         * k----一共有k个鸡蛋
         * m----最多仍m次，  m最大值取N   相当于线性遍历
         * n---表示k个鸡蛋仍m次以后 所能测出的最大楼层高度
         *
         * k == 0时   dp[0][m] = 0
         * m = 0时    dp[k][0] = 0
         *
         * dp[k][m] = 碎 + 未碎 + 1(当前扔了一次鸡蛋)
         *          = dp[k-1][m-1] + dp[k][m-1] + 1
         */
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1;
            }
        }
        return m;
    }
}
