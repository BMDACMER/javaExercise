package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 13:36
 *
 * 312. 戳气球
 */
public class PokeBallon {
    /**
     * dp[i][j] --- （i,j）之间的任意位置戳气球所获得的最大值
     * 其中 0<=i <= n+1; j <= i+1   例如：(2,3)之间无法获取最大值  开区间
     * base case : 全部初始化为 0
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        // 两端加入两个虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            points[i] = nums[i - 1];
        }

        // 开始状态转移
        for (int i = n; i >= 0; --i) {
            for (int j = i + 1; j < n + 2; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
