package guohaoAlgorithm.array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 9:51
 *
 * 面试题 10.03. 搜索旋转数组
 */
public class Search {

    //  遍历   （击败23.28%）  不是本题题意
    public int search(int[] arr, int target) {
        if (arr.length == 0) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // 二分查找    本题考察意图
    public int binarySearch(int[] arr, int target) {
        /**
         *      15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14  // 这是一串两段递增的序列
         *      l                                       r
         *              mid
         *                                  mid
         * 1)   arr[l] == target  return l
         * 2)   arr[mid] == target   r = mid
         * 3)   if(arr[l] < arr[mid]) // 说明在第一段 递增序列里   二分查找
         *            if(arr[mid] < target) l = mid+1;
         *            if(arr[mid]>target) r = mid; // 而非mid-1  注意
         *            if(arr[mid] == target)  return mid;
         *     if(arr[l] > arr[mid]) // 递增字符串在右边  二分查找
         *           if(arr[mid] < target) l = mid+1;
         *           if(arr[mid] > target) r = mid;
         *           if(arr[mid] == target)  return mid;
         *     else  l++   右移
         */
        int n = arr.length;
        if (n == 0) return -1;
        int l = 0, r = n - 1;

        while (l <= r) {
            if (arr[l] == target) return l;
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                r = mid;
            }else if (arr[l] < arr[mid]) {
                // 在第一段递增序列里
                if (arr[l] < target && target < arr[mid]) r = mid;
                else l = mid + 1;
            } else if (arr[l] > arr[mid]) {
                // 在第二段递增序列里
                if (arr[l] > target && arr[mid] < target) l = mid + 1;
                else r = mid;
            } else if (arr[l] == arr[mid]) {
                //l和mid相等，但不等于目标值，则l往前走
                l++;
            }
        }
        return -1;
    }
}
