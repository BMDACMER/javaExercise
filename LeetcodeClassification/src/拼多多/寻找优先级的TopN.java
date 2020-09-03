package ƴ���;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 9:09
 * 1���Ƚ����зֳ�������ż�����֣��ֱ�͵������ϲ������ǰN������
 * https://blog.csdn.net/Watkins_OS/article/details/100185894
 */
public class Ѱ�����ȼ���TopN {
    // ��Ϊ��ż�� ������
    public int[] topN(int[] array, int n) {
        int len = array.length;
        int[] arrayA = new int[len];
        int[] arrayB = new int[len];
        int[] arrayC = new int[len];
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        for (int i = 0; i < len; i++) {
            if ((array[i]&1) == 1) {
                arrayA[indexA++] = array[i];
            } else {
                arrayB[indexB++] = array[i];
            }
        }

        // �͵�����
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        // �鲢����
        int i=0,j=0;
        while (i < indexA && j < indexB) {
            arrayC[indexC++] = arrayA[i] < arrayB[j] ? arrayA[i] : arrayB[j];
            i++;j++;
        }

        /**
         * �����������ִ��һ��
         */
        while (i < indexA)
            arrayC[indexC++] = arrayA[i];

        while (j < indexB)
            arrayC[indexC++] = arrayB[j];

        // ���ǰn����
        return Arrays.copyOfRange(arrayC, 0, n);
    }
}
