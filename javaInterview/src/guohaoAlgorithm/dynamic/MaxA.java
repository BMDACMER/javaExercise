package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 22:24
 *
 * [LeetCode] 651. �ļ����� ����(��̬�滮)
 * �ο���https://www.cnblogs.com/fanguangdexiaoyuer/p/12785726.html
 */
public class MaxA {

    // �α�P165-167
    public int maxA(int N) {
        /**
         * ����ѡ������״̬�� A, ctrl+V, ctrl+A + ctrl+C
         * dp[i]---��i�β���ʹ����Ļ��A���������Ϊdp[i]
         * base case:  dp[0] = 0;
         * ״̬ת�Ʒ��̣�
         *          1) ǰ�ڰ�A������  dp[i] = dp[i-1] + 1;
         *          2�����ڰ�Ctrl + V���ѣ������֮ǰ�ᰴctrl+A + ctrl+C (���ŵĲ�������һ���� C-A C-C �������� C-V)
         *              for(j = 2; j < i; j ++)  dp[i] = max(dp[i], dp[j-2]*(i-j))  //jһֱС��i��˵�� j - 2 ��λ�ã�һ���ǰ���A����j - 2λ���ϱ�����ǰλ����A��������
         */
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // // �� A ��
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // ȫѡ & ���� dp[j-2]������ճ�� i - j ��
                dp[i] = Math.max(dp[i], dp[j] * (i - j + 1));
            }
        }
        //  �ΰ���֮������м��� A��
        return dp[N];
    }
}
