package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 14:38
 *
 * 322. ��Ǯ�һ�
 */
public class CoinChange {

    /**
     * dp[i][j] --- ��ֻ����ǰi����Ʒ������������Ϊjʱ����dp[i][j]�з�������װ������
     * base case:  dp[0][..] = 0, dp[..][0] = 1; ��Ϊ����������κ�Ӳ����ֵ�����޷��ճ��κν�����ճ���Ŀ��
     * ���Ϊ0����ô����Ϊ���Ρ�����Ψһһ�ַ���
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case:
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int n= coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0)
                    dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
