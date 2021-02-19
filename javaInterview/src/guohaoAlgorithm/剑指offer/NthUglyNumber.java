package guohaoAlgorithm.剑指offer;

/**
 * @Author guohao
 * @Date 2021/2/19 9:55
 * @Version 1.0
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * ?
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 *1 是丑数。
 * n不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 */
public class NthUglyNumber {

    // 参考：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9hq0r6/
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        //base case
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int na = dp[a] * 2, nb = dp[b] * 3, nc = dp[c] * 5;
            dp[i] = Math.min(Math.min(na, nb), nc);
            if (dp[i] == na) a++;
            if (dp[i] == nb) b++;
            if (dp[i] == nc) c++;
        }
        return dp[n - 1];
    }
}
