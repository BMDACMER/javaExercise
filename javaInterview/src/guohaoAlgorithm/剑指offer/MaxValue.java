package guohaoAlgorithm.��ָoffer;

/**
 * @Author guohao
 * @Date 2021/2/18 11:45
 * @Version 1.0
 *
 * ��ָ Offer 47. ���������ֵ
 * ��һ�� m*n �����̵�ÿһ�񶼷���һ�����ÿ�����ﶼ��һ���ļ�ֵ����ֵ���� 0����
 * ����Դ����̵����Ͻǿ�ʼ�ø�����������ÿ�����һ��������ƶ�һ��ֱ���������̵����½ǡ�
 * ����һ�����̼������������ļ�ֵ���������������õ����ټ�ֵ�����
 *
 * ʾ�� 1:
 *
 * ����:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * ���: 12
 * ����: ·�� 1��3��5��2��1 �����õ�����ֵ������
 */
public class MaxValue {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i- 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // ״̬ת�Ʒ���
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j -1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
