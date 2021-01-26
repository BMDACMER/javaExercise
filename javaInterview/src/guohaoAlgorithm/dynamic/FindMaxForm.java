package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 21:54
 *
 * 474. һ����
 * ����һ���������ַ������� strs ���������� m �� n ��
 *
 * �����ҳ������� strs ������Ӽ��Ĵ�С�����Ӽ��� ��� �� m �� 0 �� n �� 1 ��
 *
 * ��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * �����4
 * ���ͣ������ 5 �� 0 �� 3 �� 1 ������Ӽ��� {"10","0001","1","0"} ����˴��� 4 ��
 * �����������⵫��С���Ӽ����� {"0001","1"} �� {"10","1","0"} ��{"111001"} ���������⣬
 * ��Ϊ���� 4 �� 1 ������ n ��ֵ 3 ��
 */
public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        /**
         * dp[i][m][n] : ǰi���ַ���������m��n������Ӽ�
         *
         * base case:  ��Ϊ��
         *
         */
        int len = strs.length;
        int[][][] dp = new int[len + 1][m+1][n+1];

        for (int i = 1; i <= len; i++) {
            // ͳ��strs[i]�� 0 �� 1�ĸ���
            int count = 0;   // ͳ��0�ĸ���
            for (int j = 0; j < strs[i - 1].length(); j++) {
                if (strs[i - 1].charAt(j) == '0')
                    count++;
            }
            int count2 = strs[i - 1].length() - count;  // ͳ��1�ĸ���

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j - count >= 0 && k - count2 >= 0) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i - 1][j - count][k - count2] + 1);
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }

        return dp[len][m][n];
    }

    // �Ż�  ״̬ת�Ʒ���
    public int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= len; i++) {
            // ͳ��strs[i]�� 0 �� 1�ĸ���
            int count = 0;   // ͳ��0�ĸ���
            for (int j = 0; j < strs[i - 1].length(); j++) {
                if (strs[i - 1].charAt(j) == '0')
                    count++;
            }
            int count2 = strs[i - 1].length() - count;  // ͳ��1�ĸ���

            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j - count >= 0 && k - count2 >= 0) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - count][k - count2] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }

}
