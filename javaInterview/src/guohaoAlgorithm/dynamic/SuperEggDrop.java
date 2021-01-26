package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/26 10:41
 *
 * 887. ��������
 * https://leetcode-cn.com/problems/super-egg-drop/
 */
public class SuperEggDrop {

    public int superEggDrop(int K, int N) {
        /**
         * dp[k][m] = n
         * k----һ����k������
         * m----�����m�Σ�  m���ֵȡN   �൱�����Ա���
         * n---��ʾk��������m���Ժ� ���ܲ�������¥��߶�
         *
         * k == 0ʱ   dp[0][m] = 0
         * m = 0ʱ    dp[k][0] = 0
         *
         * dp[k][m] = �� + δ�� + 1(��ǰ����һ�μ���)
         *          = dp[k-1][m-1] + dp[k][m-1] + 1
         */
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1;
            }
        }
        return m;
    }
}
