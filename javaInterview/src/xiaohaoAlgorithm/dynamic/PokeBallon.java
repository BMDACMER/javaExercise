package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 13:36
 *
 * 312. ������
 */
public class PokeBallon {
    /**
     * dp[i][j] --- ��i,j��֮�������λ�ô���������õ����ֵ
     * ���� 0<=i <= n+1; j <= i+1   ���磺(2,3)֮���޷���ȡ���ֵ  ������
     * base case : ȫ����ʼ��Ϊ 0
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        // ���˼���������������
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            points[i] = nums[i - 1];
        }

        // ��ʼ״̬ת��
        for (int i = n; i >= 0; --i) {
            for (int j = i + 1; j < n + 2; j++) {
                // �����Ƶ��������ĸ���
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
