package xiaohaoAlgorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 13:23
 *
 * 969. �������
 *
 * �ο���https://leetcode-cn.com/problems/pancake-sorting/comments/
 * P339д�Ĳ�̫��
 */
public class PancakeSort {
    /**
     * �㷨˼�룺
     *  1���ҳ�ǰ����������Ԫ��max���±�maxIndex
     *  2����ǰmaxIndex��Ԫ�ط�ת����¼��ǰ��ת���±꣨��maxIndex+1��
     *  3����ǰarr.lengthԪ�ط�ת����¼��ǰ��ת���±�
     *  4���ݹ���ã���תʣ���Ԫ��
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int size = arr.length - 1;
        while (size > 0) {
            int maxIndex = findMaxIndex(arr, size);
            if (maxIndex < size) {
                list.add(maxIndex + 1);
                list.add(size + 1);
            }

            reverse(arr, 0, maxIndex);
            reverse(arr,0,size--);
        }
        return list;
    }

    private int findMaxIndex(int[] arr, int size) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i <= size; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    /**
     * ���ڸ÷�����ȡ���Ǽ�����ײ��λ���㣬��������µı�����������ڴ���ɶ���Ŀ�����
     * �����ٶ������ַ��������ģ����͵ڶ��ַ���һ�������ܻ����Խ�����⣬�����ֽϴ�ʱ������ʹ��
     * @param arr
     * @param i j
     */
    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            i++;
            j--;
        }
    }
}
