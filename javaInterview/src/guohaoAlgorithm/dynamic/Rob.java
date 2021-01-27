package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/27 22:22
 *
 * 198 打家劫舍
 * https://leetcode-cn.com/problems/house-robber
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    // 空间优化
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int dp_1 = nums[0];
        int dp_2 = Math.max(nums[0], nums[1]), dp_i = dp_2;
        for (int i = 2; i < n; i++) {
            dp_i = Math.max(dp_1 + nums[i], dp_2);
            dp_1 = dp_2;
            dp_2 = dp_i;
        }
        return dp_i;

    }
}
