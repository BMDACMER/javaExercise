package 动态规划;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 16:50
 *
 * 参考：链接：https://leetcode-cn.com/problems/house-robber-ii/solution/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/
 *
 */
public class 打家劫舍II {
    /**
     * 相比较上一道  多了一个循环
     * @param nums
     * @return
     */
    /*public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),   // 深拷贝
                        myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }*/

    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(myrob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myrob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myrob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        打家劫舍II m = new 打家劫舍II();
        int[] nums = {2,1,1,2};
        System.out.println(m.rob(nums));
    }
}
