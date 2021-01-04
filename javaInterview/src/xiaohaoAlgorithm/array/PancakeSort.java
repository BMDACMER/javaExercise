package xiaohaoAlgorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 13:23
 *
 * 969. 煎饼排序
 *
 * 参考：https://leetcode-cn.com/problems/pancake-sorting/comments/
 * P339写的不太好
 */
public class PancakeSort {
    /**
     * 算法思想：
     *  1）找出前数组中最大的元素max和下标maxIndex
     *  2）将前maxIndex个元素反转，记录当前反转的下标（即maxIndex+1）
     *  3）将前arr.length元素反转，记录当前翻转的下标
     *  4）递归调用，反转剩余的元素
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
     * 由于该方法采取的是计算机底层的位运算，不会产生新的变量，不会对内存造成额外的开销，
     * 运算速度是三种方法种最快的，但和第二种方法一样，可能会出现越界问题，在数字较大时不建议使用
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
