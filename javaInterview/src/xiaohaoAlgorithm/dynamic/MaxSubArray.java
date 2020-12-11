package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/11 10:55
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class MaxSubArray {

    /**
     *  时间复杂度为：O(n)
     *  空间复杂度为：O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        // dp[i] --- 以nums[i]结尾的子数组的最大和
        int[] dp = new int[n];
        int maxSum;
        maxSum = dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    /**
     * 法二：时间复杂度为：O(n)
     * 空间复杂度为：O(1)  --- 因为dp[i]只与dp[i-1]相关，可以 压缩状态 节省空间
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        int dp_0 = nums[0], dp_1;
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            maxSum = Math.max(maxSum, dp_0);
        }
        return maxSum;
    }
}
