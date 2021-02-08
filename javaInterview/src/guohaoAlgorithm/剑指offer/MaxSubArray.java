package guohaoAlgorithm.剑指offer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/8 10:45
 *
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class MaxSubArray {

    /**
     * dp[i] ---- 以nums[i]结尾的最大子数组和
     * base case dp[0] = nums[0]
     * 状态转移方程： dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    // 状态压缩
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int dp_0 = nums[0], dp_1, res = dp_0;
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }
        return res;
    }
}
