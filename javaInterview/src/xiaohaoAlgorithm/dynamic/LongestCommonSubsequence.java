package xiaohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/12 10:31
 *
 * 1143. �����������  LCS
 */
public class LongestCommonSubsequence {
    /**
     * dp[i][j] --- ��ʾstr[0..i-1]��str[0..j-1]�������������
     * dp[0][j] = 0 ---- ""��str[j-1]���������Ϊ"" ����Ϊ0
     * dp[i][0] = 0 ---- str[i-1]��""���������Ϊ"" ����Ϊ0
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 1 ����dp
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];   // �Ѿ�Ĭ�ϳ�ʼ��Ϊ0��
        // 2 base case
        Arrays.fill(dp[0],0); // �˴�����ʡ��
//        Arrays.fill(dp,0);

        // 3 ״̬ת�Ʒ���
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
