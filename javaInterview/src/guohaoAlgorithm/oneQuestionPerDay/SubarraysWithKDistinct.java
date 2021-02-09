package guohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/9 10:26
 *
 * 992. K ����ͬ������������
 * ����һ������������ A����� A ��ĳ���������в�ͬ�����ĸ���ǡ��Ϊ K����� A �������������һ��������������Ϊ�������顣
 *
 * �����磬[1,2,3,1,2] ���� 3 ����ͬ��������1��2���Լ� 3����
 *
 * ���� A �к����������Ŀ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺A = [1,2,1,2,3], K = 2
 * �����7
 * ���ͣ�ǡ���� 2 ����ͬ������ɵ������飺[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * ʾ�� 2��
 *
 * ���룺A = [1,2,1,3,4], K = 3
 * �����3
 * ���ͣ�ǡ���� 3 ����ͬ������ɵ������飺[1,2,1,3], [2,1,3], [1,3,4].
 *
 * ��ʾ��
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 */
public class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostWithKDistinct(A, K) - atMostWithKDistinct(A, K - 1);
    }

    /**
     * ������K����ͬ������������ĸ���
     * @param A
     * @param K
     * @return
     */
    private int atMostWithKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];  // ��ĿҪ�� 1 <= A[i] <= A.length

        int left = 0, right = 0;
        int count = 0, res = 0;   // [left, right)
        while (right < len) {
            if (freq[A[right]] == 0)
                count++;
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0)
                    count--;
                left++;
            }
            // [left, right) ����ĳ��Ⱦ��ǶԽ���Ĺ���
            res += right - left;
        }
        return res;
    }
}
