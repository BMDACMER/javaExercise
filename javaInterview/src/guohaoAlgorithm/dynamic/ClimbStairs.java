package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/24 23:02
 *
 * 70. 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /**
         * dp[i] -- 爬到第i阶的不同方法   i>=1
         * dp[1] = 1  d[2] = 2
         * dp[i] = max(dp[i-2]+1, dp[i-1]+1);
         */
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }

}
