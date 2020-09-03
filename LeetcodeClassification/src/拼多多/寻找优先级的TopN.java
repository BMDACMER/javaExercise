package 拼多多;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 9:09
 * 1、先将序列分成奇数和偶数部分，分别就地排序后合并。输出前N个数字
 * https://blog.csdn.net/Watkins_OS/article/details/100185894
 */
public class 寻找优先级的TopN {
    // 分为奇偶数 在排序
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

        // 就地排序
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        // 归并排序
        int i=0,j=0;
        while (i < indexA && j < indexB) {
            arrayC[indexC++] = arrayA[i] < arrayB[j] ? arrayA[i] : arrayB[j];
            i++;j++;
        }

        /**
         * 下面两个最多执行一个
         */
        while (i < indexA)
            arrayC[indexC++] = arrayA[i];

        while (j < indexB)
            arrayC[indexC++] = arrayB[j];

        // 输出前n个数
        return Arrays.copyOfRange(arrayC, 0, n);
    }
}
