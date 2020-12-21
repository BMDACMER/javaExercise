package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/21 9:08
 * �ο���https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/
 * 746. ʹ����С������¥��
 */
public class MinCostClimbingStairs {

    /**
     * ��̬�滮��dp[i] --- �����i�׵���С����  i��0��ʼ
     * base case��
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
     * ״̬ѹ�����Ż�
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
