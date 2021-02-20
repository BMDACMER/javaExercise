package guohaoAlgorithm.dynamic;

/**
 * @Author guohao
 * @Date 2021/2/20 8:29
 * @Version 1.0
 *
 * 264. ���� II
 * ��дһ�������ҳ��� n ��������
 *
 * ��������������ֻ���� 2, 3, 5 ����������
 *
 * ʾ��:
 *
 * ����: n = 10
 * ���: 12
 * ����: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 ��ǰ 10 ��������
 */
public class NthUglyNumber {

    // �����뽣ָoffer�ϵ�  ��ָ Offer 49. ����  ͬ��
    public int nthUglyNumber(int n) {
        // dp[i] ----- ����� i + 1i+1 ������
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0, na, nb, nc;
        for (int i = 1; i < n; i++) {
            na = dp[a] * 2;
            nb = dp[b] * 3;
            nc = dp[c] * 5;
            dp[i] = Math.min(Math.min(na, nb), nc);
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }
}
