package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author guohao
 * @Date 2021/2/18 9:09
 * @Version 1.0
 */
public class MinKBitFlips {

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }
//
//    ���ߣ�LeetCode-Solution
//    ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-bikk/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
    public int minKBitFlips2(int[] A, int K) {
        int len = A.length;
        // �洢���� Ҫ��ת��������߽磬���д�СΪ��ǰԪ��Ҫ��ת����
        Deque<Integer> transformRange = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            // ���ﵱǰ��������С�ı߽�ʱ��Ҫ�����ų�
            if (!transformRange.isEmpty() && transformRange.peekFirst() == i) transformRange.pollFirst();
            // ��i��Ԫ�ص�ʵ��ֵ��ΪA[i]���Ϸ�ת����
            int cur = A[i] + transformRange.size();

            // ��ǰλ�õ�ʵ��ֵ��Ϊ1�����
            if (cur % 2 == 0) {
                // ��ʾ�µı߽��Ѿ��������鳤�����ߣ�����������ܳ���������-1
                if(i + K > len) return -1;
                // ��[i, i + K]֮���Ԫ�ط�תһ�Σ�����ת�ķ�Χ�߽�������
                transformRange.offerLast(i + K);
                cnt++;
            }
        }
        return cnt;
    }
}
