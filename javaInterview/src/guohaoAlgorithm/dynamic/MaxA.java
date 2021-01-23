package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 22:24
 *
 * [LeetCode] 651. 四键键盘 ☆☆☆(动态规划)
 * 参考：https://www.cnblogs.com/fanguangdexiaoyuer/p/12785726.html
 */
public class MaxA {

    // 课本P165-167
    public int maxA(int N) {
        /**
         * 按键选择三个状态： A, ctrl+V, ctrl+A + ctrl+C
         * dp[i]---第i次操作使得屏幕上A的数量最大为dp[i]
         * base case:  dp[0] = 0;
         * 状态转移方程：
         *          1) 前期按A更合适  dp[i] = dp[i-1] + 1;
         *          2）后期按Ctrl + V更佳，因此在之前会按ctrl+A + ctrl+C (最优的操作序列一定是 C-A C-C 接着若干 C-V)
         *              for(j = 2; j < i; j ++)  dp[i] = max(dp[i], dp[j-2]*(i-j))  //j一直小于i，说明 j - 2 的位置，一定是按键A，即j - 2位置上表明当前位置上A的最大个数
         */
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // // 按 A 键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                dp[i] = Math.max(dp[i], dp[j] * (i - j + 1));
            }
        }
        //  次按键之后最多有几个 A？
        return dp[N];
    }
}
