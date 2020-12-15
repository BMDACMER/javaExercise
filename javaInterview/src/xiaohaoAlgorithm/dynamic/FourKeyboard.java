package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/15 9:34
 * 651	 4������
 *
 * �ο���P165-167
 */
public class FourKeyboard {
    /**
     * dp[i]---����i�κ���Ļ�����dp[i]��A
     * @param n
     * @return
     */
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;  // ��A�����ͱ���һ�ζ�һ��A����
            // ��C-V����ٰ���C-A  C-C��ʱ��
            for (int j = 2; j < i; j++) {
                // �����ʱ����C-A   C-C�Ļ�
                // ��i�ΰ�����ʱ����������A������Ϊdp[i - 2]
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N�ΰ���֮������м���A��
        return dp[n];
    }
}
