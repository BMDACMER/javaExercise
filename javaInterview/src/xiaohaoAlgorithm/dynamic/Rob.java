package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/17 16:15
 * 198. 打家劫舍
 */
public class Rob {

    /**
     * dp[i] ---  表示从当前i位置打劫，所获得的最大价值
     * dp[0] = nums[0];
     * dp[1] = nums[1];
     *
     * dp[i] = max(dp[i-1], dp[i-2]+nums[i])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length < 2) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

    /**
     * 压缩状态
     * @param args
     */
    public int rob2(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int dp_0 = nums[0], dp_1 = Math.max(nums[0], nums[1]);
        int dp_i = dp_1;

        for (int i = 2; i < nums.length; i++) {
            dp_i = Math.max(dp_1, dp_0 + nums[i]);
            dp_0 = dp_1;
            dp_1 = dp_i;
        }
        return dp_i;
    }

    public static void main(String[] args) {
        Rob ro = new Rob();
        int[] nums = {2,1,1,2};
        int res = ro.rob2(nums);
        System.out.println(res);
    }
}
