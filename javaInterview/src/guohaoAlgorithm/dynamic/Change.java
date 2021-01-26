package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 21:19
 *
 * 518. ��Ǯ�һ� II
 * ������ͬ����Ӳ�Һ�һ���ܽ�д��������������Դճ��ܽ���Ӳ�������������ÿһ������Ӳ�������޸���
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: amount = 5, coins = [1, 2, 5]
 * ���: 4
 * ����: �����ַ�ʽ���Դճ��ܽ��:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class Change {

    public int change(int amount, int[] coins) {
        /**
         * dp[i][amount]: ǰi���� �ճ�amount��� �ܹ��ķ���
         * dp[0][amount] = 0, dp[i][0] = 1 // ��Ϊ��ʹ���κ�Ӳ�����ԣ��޷��ճ�Ӳ��
         *
         * dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
         */
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {// i��0��ʼ���Ա�����������
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    // ״̬ѹ���� ��ȫ��������  �ڲ�ѭ����С����  0-1�������� ��ѭ���Ӵ�С
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
}
