package guohaoAlgorithm.leetcodeCompettition;

import java.util.PriorityQueue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/24 22:09
 * 5663. 找出第 K 大的异或坐标值
 *
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ matrix[i-1][j-1];
                q.offer(dp[i][j]);
                if (q.size() > k) {
                    q.poll();
                }
            }
        }
        return q.peek();
    }
}
