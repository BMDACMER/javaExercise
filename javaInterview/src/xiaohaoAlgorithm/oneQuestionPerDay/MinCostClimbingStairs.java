package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/21 9:08
 * 参考：https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    /**
     * 动态规划：dp[i] --- 到达第i阶的最小花费  i从0开始
     * base case：
     * dp[0] = 0;
     * dp[1] = min(cost[0], cost[1])
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] dp = new int[size];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < size; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i-1]);
        }
        return dp[size - 1];
    }

    /**
     * 状态压缩，优化
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        int size = cost.length;
        int minCost1 = 0, minCost2 = Math.min(cost[0], cost[1]);
        int minCost = 0;
        for (int i = 1; i < size; i++) {
            minCost = Math.min(minCost2 + cost[i], minCost1 + cost[i - 1]);
            minCost1 = minCost2;
            minCost2 = minCost;
        }

        return minCost;
    }
}
