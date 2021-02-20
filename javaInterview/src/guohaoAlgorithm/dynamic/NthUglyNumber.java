package guohaoAlgorithm.dynamic;

/**
 * @Author guohao
 * @Date 2021/2/20 8:29
 * @Version 1.0
 *
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class NthUglyNumber {

    // 该题与剑指offer上的  剑指 Offer 49. 丑数  同题
    public int nthUglyNumber(int n) {
        // dp[i] ----- 代表第 i + 1i+1 个丑数
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0, na, nb, nc;
        for (int i = 1; i < n; i++) {
            na = dp[a] * 2;
            nb = dp[b] * 3;
            nc = dp[c] * 5;
            dp[i] = Math.min(Math.min(na, nb), nc);
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }
}
