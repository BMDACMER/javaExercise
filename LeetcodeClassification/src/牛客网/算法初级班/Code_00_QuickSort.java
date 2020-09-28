package 牛客网.算法初级班;

import static 牛客网.算法初级班.Code_00_SelectionSort.swap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/20 17:43
 * 快速排序
 */
public class Code_00_QuickSort {
     public static void quickSort(int[] arr) {
         if (arr == null || arr.length < 2)
             return;
         quickSort(arr, 0, arr.length - 1);
     }

    private static void quickSort(int[] arr, int l, int r) {
         if (l < r) {
             swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
             int[] p = partition(arr, l, r);
             quickSort(arr, l, p[0] - 1);
             quickSort(arr, p[1] + 1, r);
         }
    }

    private static int[] partition(int[] arr, int l, int r) {
         int less = l - 1;
         int more = r;
         while (l < more) {
             if (arr[l] < arr[r]) {
                 swap(arr, ++less, l++);
             } else if (arr[l] > arr[r]) {
                 swap(arr, --more, l);
             } else {
                 l++;
             }
         }
         swap(arr, more, r);
         return new int[] {less+1, more};
    }

    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Util.generatorRandomArray(maxSize, maxValue);
            int[] arr2 = Util.copyArray(arr1);
            quickSort(arr1);
            Util.comparator(arr2);
            if (!Util.isEquals(arr1, arr2)) {
                succeed = false;
                Util.printArray(arr1);
                Util.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = Util.generatorRandomArray(maxSize, maxValue);
        Util.printArray(arr);
        quickSort(arr);
        Util.printArray(arr);
    }

}
