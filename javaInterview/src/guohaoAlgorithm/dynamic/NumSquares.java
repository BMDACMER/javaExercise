package guohaoAlgorithm.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/25 21:54
 *
 * 279. 完全平方数
 *
 * 跟 322. 零钱兑换 类似
 */
public class NumSquares {

    /*// 动态规划  1 <= n <= 10^4     击败13.14%  32.25%
    public int numSquares(int n) {
        int[] dp = new int[n+1];  // 表示 凑出n需要的最少个数
        ArrayList<Integer> list = new ArrayList<>();
        // 找出小于等于n的完全平方数
        int index = 1;
        while (index * index <= n) {
            list.add(index * index);
            index++;
        }

        Arrays.fill(dp, n + 1);
        dp[0] = 0;  // base case     凑出0元需要0枚硬币
        for (int i = 1; i <= n; i++) {
            for (int num : list) {
                if (i - num < 0) break;  // 有序 所以用break
                dp[i] = Math.min(dp[i], dp[i-num] + 1);
            }
        }
        return dp[n];
        //dp[amount] == amount + 1 ? -1 : dp[amount];
    }*/

    // 方法二：  dfs + 贪心
    int ans = Integer.MAX_VALUE;
    public int numSquares(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int index =1;
        while (index * index <= n) {
            arr.add(index * index);
            index++;
        }

        dfs(arr, n, arr.size() - 1, 0);
        return ans;
    }

    /**
     *
     * @param arr  --- 硬币的面值
     * @param amount --- 需要凑出的数
     * @param index --- 索引   在arr中从右向左遍历   按照贪心策略
     * @param count  --- 统计需要多少枚硬币
     */
    private void dfs(ArrayList<Integer> arr, int amount, int index, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        // 终止条件   遍历完 arr数组
        if (index < 0)
            return;

        for (int i = amount / arr.get(index); i >= 0 && i + count < ans; --i) {
            dfs(arr, amount - i * arr.get(index), index - 1, count + i);
        }
    }


    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        System.out.println(n.numSquares(312));
    }
}
