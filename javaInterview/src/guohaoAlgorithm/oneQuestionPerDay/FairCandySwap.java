package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 9:05
 *
 * 888. ��ƽ���ǹ�������
 * ����˿�ͱ����в�ͬ��С���ǹ�����A[i] �ǰ���˿ӵ�еĵ� i ���ǹ����Ĵ�С��B[j] �Ǳ���ӵ�еĵ� j ���ǹ����Ĵ�С��
 *
 * ��Ϊ���������ѣ����������뽻��һ���ǹ������������������Ƕ�����ͬ���ǹ���������һ����ӵ�е��ǹ�����������ӵ�е��ǹ�����С���ܺ͡���
 *
 * ����һ���������� ans������ ans[0] �ǰ���˿���뽻�����ǹ����Ĵ�С��ans[1] �� Bob ���뽻�����ǹ����Ĵ�С��
 *
 * ����ж���𰸣�����Է��������κ�һ������֤�𰸴��ڡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺A = [1,1], B = [2,2]
 * �����[1,2]
 *
 * ʾ�� 2��
 *
 * ���룺A = [1,2], B = [2,3]
 * �����[1,2] �� [2,3]����
 *
 * ʾ�� 3��
 *
 * ���룺A = [2], B = [1,3]
 * �����[2,3]
 *
 * ʾ�� 4��
 *
 * ���룺A = [1,2,5], B = [2,4]
 * �����[5,4]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/fair-candy-swap
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FairCandySwap {

    // ˼·����Ϊһ������ �����Զ������һ��Ϊż��  ȡƽ��  һ������ һ�����٣�
    // ��A��B����ֱ���hashmap���棬ȡ��С��Ԫ�ص����� + ���ƽ����  �ж��Ƿ�զB�����д��ڣ�������һ�����ڣ� ������
    // ��ʱ 30ms ����27%
    /*public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int sum = 0;
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int a : A) {
            mapA.put(a, mapA.getOrDefault(a, 0) + 1);
            sum += a;
        }
        for (int b : B) {
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
            sum -= b;
        }

        // ��ʾ��˵   A Bһ������� ---�� sum != 0
        if (sum > 0) {
            // ˵��A������
            int avg = sum / 2;
            for (int i = 0; i < A.length; i++) {
                if (mapB.containsKey(A[i] - avg)) {
                    ans[0] = A[i];
                    ans[1] = A[i] - avg;
                    return ans;
                }
            }

        } else {
            // ˵�� B������
            int avg = Math.abs(sum) / 2;
            for (int i = 0; i < B.length; i++) {
                if (mapA.containsKey(B[i] - avg)) {
                    ans[0] = B[i] - avg;
                    ans[1] = B[i];
                    return ans;
                }
            }
        }
        return ans;
    }*/

    // ������  �Ż�����  ����hashSet����  �Ż���19ms   ����32%
    public int[] fairCandySwap2(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int avg = (sumA - sumB) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);

        int[] ans = new int[2];
        for (int i = 0; i < B.length; i++) {
            if (set.contains(B[i] + avg)) {
                ans[0] = B[i] + avg;
                ans[1] = B[i];
                break;
            }
        }
        return ans;
    }
}
