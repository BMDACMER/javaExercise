package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/24 9:38
 *
 * 674. 最长连续递增序列  easy
 */
public class FindLengthOfLCIS {

    /**
     * 输入：nums = [1,3,5,4,7]
     * 输出：3
     * 解释：最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int left = 0, right = 0, len = 1;
        while (right < n - 1) {
            if (nums[right] > nums[right + 1]) {
                len = Math.max(len, right - left + 1);
                left = right + 1;
            }
            right++;
        }
        // 最后一次也做比较 [1,3,5,7]
        len = Math.max(len, right - left + 1);
        return len;
    }

    // 动态规划 解法
    /**
     * dp[i]----以nums[i]结尾的最大连续递增序列
     * base case: dp[i] = 1
     * 状态转移： if(nums[i] > nums[i-1]) dp[i] = dp[i-1] + 1;
     * return dp[i]中最大的
     */
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp  =new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1])
                dp[i] = dp[i-1] + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
