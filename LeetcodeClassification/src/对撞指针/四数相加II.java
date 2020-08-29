package ��ײָ��;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 17:21
 * 454 �������II
 * https://leetcode-cn.com/problems/4sum-ii/
 * <p>
 * ˼·����4������ֳ����飬�����㷨ʱ�临�Ӷ�Ϊ O(N*N)
 * <p>
 * 1�����÷�Ϊ���飬HashMap��һ�飬��һ���HashMap���бȶԡ�
 * 2��HashMap����������֮�ͣ���AB��Ȼ�������������֮�ͣ���CD��ʱ�临�Ӷ�Ϊ��O(n^2)+O(n^2),�õ�O(n^2).
 * 3�������Դ�AB������֮��Ϊ�����������A��B��������֮��sumAB����sumABΪkey��sumAB���ֵĴ���Ϊvalue������hashmap�С�
 * Ȼ�����C��D����������֮�͵��෴��sumCD����hashmap�в����Ƿ����keyΪsumCD��
 */
public class �������II {
    /*public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[i];
                map.put(sumAB, map.getOrDefault(sumAB,0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i] + D[i]);
                if (map.containsKey(sumCD))
                    res += map.get(sumCD);
            }
        }

        return res;
    }*/

    /*public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[j];
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i] + D[i]);
                if (map.containsKey(sumCD))
                    res += map.get(sumCD);
            }
        }

        return res;
    }*/

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int temp = A[i] + B[j];
                map.put(temp, map.getOrDefault(temp,0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int temp = -(C[i] + D[j]);
                if (map.containsKey(temp))
                    sum += map.get(temp);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        �������II m = new �������II();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(m.fourSumCount(A, B, C, D));
    }

}
