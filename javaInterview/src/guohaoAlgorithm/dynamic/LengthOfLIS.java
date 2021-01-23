package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 11:03
 *
 * 300. 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class LengthOfLIS {

    // 动态规划
    public int lengthOfLIS(int[] nums) {
        /**
         * dp[i] --- 在数组下标i的位置之前的最大上升子序列
         * 每个子序列全都初始化为1
         * 对于 j ∈[0,i)，只要找到比nums[i]小的元素，然后将nums[i]接到后面即可。长度加一：
         *              dp[i] = max(dp[i], dp[j] + 1);
         *  最后，遍历整个dp数组，找出最大即可
         */
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //  方法二： 二分搜索  参考P102-103
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int piles = 0;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = nums[i];

            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } if (top[mid] < poker) {
                    left = mid + 1;
                } else if (top[mid] == poker) {
                    right = mid;
                }
            }
            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }


    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(l.lengthOfLIS2(nums));
    }
}
