package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 11:38
 *
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {

    // dp[i] --- 以nums[i]结束的连续子数组的最大和
    // dp[0] = nums[0];
    // 要么自成一派 要么和之前的合并    dp[i] = max(num[i], dp[i-1] + nums[i])
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 优化 状态压缩
    public int maxSubArrays(int[] nums) {
        int n = nums.length;
        int dp_1 = nums[0], dp_2;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp_2 = Math.max(nums[i], dp_1 + nums[i]);
            dp_1 = dp_2;
            max = Math.max(dp_2, max);
        }
        return max;
    }
}
