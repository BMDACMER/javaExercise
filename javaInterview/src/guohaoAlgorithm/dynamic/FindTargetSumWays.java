package guohaoAlgorithm.dynamic;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 22:55
 *
 * 0-背包问题
 *
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 */
public class FindTargetSumWays {

    // 动态规划  二维
    public int findTargetSumWays(int[] nums, int S) {
        /**
         *
         * max = sum(nums) * 2 -1  // - 0 +
         * dp[i][max+s] ---- 前i个元素通过+/-能够表示s的方法数, max相当于处于0这个位置
         * dp[0][s] = 1;   //只有一种方法
         * dp[i][s] = dp[i-1][s+nums[i-1]] + dp[i-1][s-nums[i-1]]
         */

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(S) > sum) return 0; // 总和小于s的肯定不能凑出   直接返回0
        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][sum] = 1;  // 相当于位于 原点位置
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                int l = j - nums[i -1] >= 0 ? j - nums[i -1] : 0;
                int r = j + nums[i - 1] <= 2 * sum ? j + nums[i - 1] : 2 * sum;
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }
        return dp[n][sum+S];
    }

    // 动态规划  一维   没通过
    public int findTargetSumWays2(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(S) > sum) return 0;

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 2 * sum; j >= 0; j--) {
                int l = j - nums[i - 1] >= 0 ? j - nums[i - 1] : 0;
                int r = j + nums[i - 1] <= 2 * sum ? j + nums[i - 1] : 2 * sum;
                dp[j] = dp[l] + dp[r];
            }
        }
        return dp[sum + S];
    }

    // dfs 回溯法
    public int findTargetSumWaysDFS(int[] nums, int S) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, S);
    }

    HashMap<String, Integer> memo = new HashMap<>();
    private int dp(int[] nums, int index, int s) {
        if (index == nums.length){
            if (s == 0) return 1;
            return 0;
        }

        String key = index + "," + s;
        if (memo.containsKey(key)) return memo.get(key);
        int res = dp(nums, index + 1, s + nums[index]) + dp(nums, index + 1, s - nums[index]);
        memo.put(key, res);
        return res;
    }
}
