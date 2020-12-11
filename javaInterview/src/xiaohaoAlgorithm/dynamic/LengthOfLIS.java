package xiaohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/11 9:48
 *
 * 300. 最长上升子序列
 */
public class LengthOfLIS {

    /**
     * 动态规划
     * dp[i] ---- 代表字符串中截至每个字符所在位置的最大上升子序列长度
     * 单个字符可视为上升子序列，因此初始化为1
     * 时间复杂度为O(n*n)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 状态转移方程
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    /**
     * 法二：二分搜索法  时间复杂度为O(nlogn)
     *
     */
    public int lenghtOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的牌数
            int poker = nums[i];

            /*搜索左侧边界的二分搜索*/
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] < poker) {
                    left = mid + 1;
                } else if (top[mid] > poker) {
                    right = mid;
                } else {
                    right = mid;
                }
            }

            // 没有找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是LIS的长度
        return piles;
    }
}
