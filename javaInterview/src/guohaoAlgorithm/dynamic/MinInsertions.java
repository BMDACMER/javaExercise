package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 21:06
 *
 * 1312. ���ַ�����Ϊ���Ĵ������ٲ������
 *
 * https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */
public class MinInsertions {

    /**
     * ���룺s = "mbadm"
     * �����2
     * ���ͣ��ַ����ɱ�Ϊ "mbdadbm" ���� "mdbabdm" ��
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        /*
        dp[i][j] --- ��ʾ��ɻ��Ĵ�s[i,j]��Ҫ��������ٴ���
        if(s[i] == s[j])  dp[i][j] = dp[i+1,j-1];
        else dp[i][j] = min(dp[i][j-1], dp[i+1][j]) + 1;

        base case :  i<=j  ���i>j ���Ϸ� �����   dp[i][i] = 0;
        ��Ҫ�������   �������Ҵ��µ��ϣ�
         */
        if (s == null || "".equals(s)) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
                }
            }
        }
        return dp[0][n-1];
    }

}
