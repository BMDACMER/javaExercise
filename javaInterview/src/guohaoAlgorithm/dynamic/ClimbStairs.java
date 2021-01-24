package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/24 23:02
 *
 * 70. ��¥��
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    /**
     * ������������¥�ݡ���Ҫ n ������ܵ���¥����
     *
     * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
     *
     * ע�⣺���� n ��һ����������
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /**
         * dp[i] -- ������i�׵Ĳ�ͬ����   i>=1
         * dp[1] = 1  d[2] = 2
         * dp[i] = max(dp[i-2]+1, dp[i-1]+1);
         */
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }

}
