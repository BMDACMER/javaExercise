package guohaoAlgorithm.��ָoffer;

/**
 * @Author guohao
 * @Date 2021/2/19 9:55
 * @Version 1.0
 * ���ǰ�ֻ���������� 2��3 �� 5 ��������������Ugly Number�����󰴴�С�����˳��ĵ� n ��������
 *
 * ?
 *
 * ʾ��:
 *
 * ����: n = 10
 * ���: 12
 * ����: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 ��ǰ 10 ��������
 * ˵��:
 *
 *1 �ǳ�����
 * n������1690��
 * ע�⣺��������վ 264 ����ͬ��https://leetcode-cn.com/problems/ugly-number-ii/
 */
public class NthUglyNumber {

    // �ο���https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9hq0r6/
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        //base case
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int na = dp[a] * 2, nb = dp[b] * 3, nc = dp[c] * 5;
            dp[i] = Math.min(Math.min(na, nb), nc);
            if (dp[i] == na) a++;
            if (dp[i] == nb) b++;
            if (dp[i] == nc) c++;
        }
        return dp[n - 1];
    }
}
