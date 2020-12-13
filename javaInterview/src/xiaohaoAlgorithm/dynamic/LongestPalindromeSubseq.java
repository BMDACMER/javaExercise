package xiaohaoAlgorithm.dynamic;

import javabase.Array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/13 10:53
 * 516. �����������
 */
public class LongestPalindromeSubseq {
    /**
     * dp[i][j] ---- ��ʾs[i,j]�ִ�������ĳ���
     * i <= j   ���i == j ���ȻΪ1����i<j ������  ��ʼ��Ϊ0
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // ���ű���
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        // ����s������������г���
        return dp[0][n-1];
    }

    /**
     * ״̬ѹ��
     */
    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = n-2; i >= 0; --i) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j))
                    dp[j] = pre + 2;
                else
                    dp[j] = Math.max(dp[j], dp[j-1]);
                pre = temp;
            }
        }
        return dp[n-1];
    }
}
