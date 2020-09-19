package 牛客网.算法初级班;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/19 22:09
 * 堆排序
 */

public class Code_00_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    // 弹出元素，自行调整成原始的大顶堆
    private static void heapify(int[] arr, int i, int size) {
        int leftChild = 2 * i + 1;
        while (leftChild < size) {
            int largest = leftChild + 1 < size && arr[leftChild + 1] > arr[leftChild] ? leftChild + 1 : leftChild;
            largest = arr[largest] > arr[leftChild] ? largest : i;
            if (largest == i) {
                break;
            }
            swap(arr, largest, i);
            i = largest;
            leftChild = i * 2 + 1;
        }
    }

    // 交换首尾元素
    private static void swap(int[] arr, int zhuzhu, int gougou) {
        int temp = arr[zhuzhu];
        arr[zhuzhu] = arr[gougou];
        arr[gougou] = arr[zhuzhu];
    }

    // 插入元素，即 构建大顶堆
    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }



}
