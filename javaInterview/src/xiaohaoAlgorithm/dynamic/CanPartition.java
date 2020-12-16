package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 14:13
 * 416. 分割等和子集
 */
public class CanPartition {

    /**
     * dp[i][j] = x -- 对于前i个物品，当前背包的容量为j时，若x为true， 则说明恰好将背包装满
     * 若x为false，说明不能恰好将背包装满
     * base case: dp[..][0] = true 表示背包没有容量时，说明已经装满了
     *             dp[0][..] = false 表示没有物品了，说明不能装了
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int size = 0;
        for (int i = 0; i < n; i++) {
            size += nums[i];
        }
        if (size % 2 != 0) return false;

        size /= 2;
        boolean[][] dp = new boolean[n+1][size + 1];
        // base case:
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= size; j++) {
                if (j - nums[i - 1] < 0)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i - 1]];
            }
        }
        return dp[n][size];
    }


    // 方法二：状态压缩
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int size = 0;
        for (int i = 0; i < n; i++) {
            size += nums[i];
        }
        if (size % 2 != 0) return false;

        size /= 2;
        // base case
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = size; j >= 0; --j) {
                if (j - nums[i - 1] > 0)
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }

        return dp[size];
    }
}
