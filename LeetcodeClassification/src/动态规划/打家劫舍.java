package 动态规划;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 16:27
 */
public class 打家劫舍 {

    /**
     * dp[i]表示偷窃第i号房子能得到的最高金额
     * @param nums
     * @return
     */
    public int getMaxMoney(int[] nums) {
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
        打家劫舍 m = new 打家劫舍();
        int[] nums = {2,1,1,2};
        System.out.println(m.getMaxMoney(nums));
    }
}
