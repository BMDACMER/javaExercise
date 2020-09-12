package 动态规划;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 13:40
 *
 * 300 最长上升子序列
 *
 * 采用动态规划方式
 *
 * 1）dp[i] --- 存放数组前i个元素的最大子序列长度
 * 2）对于 j 在 (0,i)区间
 *      if num[i] > num[j]，dp[i] = Math.max(dp[i], dp[j] + 1);
 *      否则 什么也不做
 * 3）初始化状态  dp[i] = 1;  // 因为每个元素都可能是最大子序里，其长度为 1
 */
public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);   // 确定动态规划状态

        // 找出dp[i]中最大的数即为 最大子序列长度
        int maxL = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }

        return maxL;
    }

    public static void main(String[] args) {
        最长上升子序列 m = new 最长上升子序列();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(m.lengthOfLIS(nums));
    }

    private int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
