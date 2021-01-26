package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 20:17
 *
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        sum /= 2;
        /**
         * dp[i][w] --- 对于前i个数字，存在之和为w的  则为true，否则false
         * dp[0][w] = false  dp[i][0] = true
         * dp[i][w] = dp[i-1][w] || dp[i-1][w-nums[i-1]]
         */
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    /**
     * 优化   状态压缩
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        CanPartition c = new CanPartition();
        int[] nums = {1, 5, 11, 5};
        System.out.println(c.canPartition(nums));
    }
}
