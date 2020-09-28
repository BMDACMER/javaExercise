package 牛客网.算法初级班;

import static 牛客网.算法初级班.Code_00_SelectionSort.swap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/28 16:41
 */
public class QuickSort {
    public static void myQuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        myQuickSort(arr, 0, arr.length - 1);
    }

    private static void myQuickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int temp = l, i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[temp]) j--;
            while (i < j && arr[i] <= arr[temp]) i++;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // 将基准值与最终值交换
        swap(arr, i, temp);

        myQuickSort(arr, l, j - 1);
        myQuickSort(arr, j + 1, r);
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Util.generatorRandomArray(maxSize, maxValue);
            int[] arr2 = Util.copyArray(arr1);
            myQuickSort(arr1);
            Util.comparator(arr2);
            if (!Util.isEquals(arr1, arr2)) {
                succeed = false;
                Util.printArray(arr1);
                Util.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "nice!" : "Fucking fucked!");
        int[] arr = Util.generatorRandomArray(maxSize, maxValue);
        Util.printArray(arr);
        myQuickSort(arr);
        Util.printArray(arr);
    }
}
