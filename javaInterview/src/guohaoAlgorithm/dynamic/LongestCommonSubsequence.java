package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 19:02
 *
 * 1143. �����������
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * ���룺text1 = "abcde", text2 = "ace"
 * �����3
 * ���ͣ�������������� "ace"�����ĳ���Ϊ 3��
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // base case ��Ϊ��
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n1][n2];
    }
}
