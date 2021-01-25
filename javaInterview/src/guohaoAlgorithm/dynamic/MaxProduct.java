package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/25 20:29
 *
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        // dp[i]----以nums[i]为结束的子数组的最大乘积
        /**
         * dp[0] --- [2]     2
         * dp[1] --- [2,3]  2*3=6
         * dp[2] --- [-2]  -2
         * dp[3] --- [4]  4
         *
         * 最后统计dp中最大的即可
         * base case: dp[i] = nums[i];
         * dp[i] = max(dp[i], dp[i-1] * nums[i]);
         *
         * 因为负数的存在 上面的不成立
         */
        int n = nums.length;
        int maxValue = 1, minValue = 1, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                int temp = maxValue;
                maxValue = minValue;
                minValue = temp;
            }
            maxValue = Math.max(maxValue * nums[i], nums[i]);
            minValue = Math.min(minValue * nums[i], nums[i]);

            max = Math.max(maxValue, max);
        }

        return max;
    }
}
