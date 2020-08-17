package 分治;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 最大子序和
 */
public class 最大子序和动态规划 {
    /*public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // 初始化
        for (int i = 1; i < nums.length; i++) {
            // 状态转移方程
            if (dp[i-1] >= 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // dp数组中记录了所有的子序列的和，找出最大的即可
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/
    // 进一步优化
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        最大子序和动态规划 aa = new 最大子序和动态规划();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
