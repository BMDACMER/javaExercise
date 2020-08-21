package ��̬�滮;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 15:15
 *
 * 516. �����������
 *  ����������� ������ ��������
 *
 */
public class ����������� {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // 1) ����dp[i][j]: ��ʾ�ӵ�i������Ϊֹ��Ԫ�ص���j��Ԫ�ص� ������
        int[][] dp = new int[n][n];

        // ���ֻ��һ���ַ�����Ȼ����������г����� 1��Ҳ���� dp[i][j] = 1 (i == j)
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        // i �����һ���ַ���ʼ��ǰ������j �� i + 1 ��ʼ����������������Ա�֤ÿ�������ⶼ�Ѿ�����ˡ�
        for (int i = n - 1; i >= 0; --i) {
       //     dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        //  ���� s ��������Ӵ�����
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        ����������� m = new �����������();
        System.out.println(m.longestPalindromeSubseq("bbbbb"));
    }
}
