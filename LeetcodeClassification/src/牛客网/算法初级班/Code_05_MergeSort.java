package 牛客网.算法初级班;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @|date: 2020/9/20 19:11
 *  归并排序
 */
public class Code_05_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return;
        int mid = l + ((r - l) >> 1);   // 可以防止溢出
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 将剩余的直接复制到下面的即可
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 将数组拷贝回去
        for (i = 0; i < help.length; ++i)
            arr[l + i] = help[i];
    }

    // 主函数测试
    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Util.generatorRandomArray(maxSize, maxValue);
            int[] arr2 = Util.copyArray(arr1);
            // 比较
            mergeSort(arr1);
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
        mergeSort(arr);
        Util.printArray(arr);

    }
}
