package ̰���㷨;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 17:59
 *
 * 1005 K ��ȡ������󻯵������
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class K��ȡ������󻯵������ {
    public int largestSumAfterKNegations(int[] A, int K) {
        int res = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] = -A[i];
                K--;
            }
        }
        // ��Ϊ���Զ�ͬһ������λ��i���� ������A[i] > 0ʱ ż�����Ե���������ֻ��Ҫȡ������һ��������
        Arrays.sort(A);
        if (K % 2 != 0) {
            A[0] = -A[0];
        }

        // ͳ���ܺ�
        for (int i = 0; i < A.length; i++) {
            res += A[i];
        }
        return res;
    }
}
