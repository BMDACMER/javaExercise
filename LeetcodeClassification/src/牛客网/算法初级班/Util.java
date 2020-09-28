package 牛客网.算法初级班;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/19 21:59
 *  负责排序算法的公共部分
 */
public class Util {
    /**
     * 辅助函数
     * 1）比较函数
     * 2） 生成随机数组
     * 3） 复制数组
     * 4） 判断是否相等
     * 5） 打印数组
     */
    // 1) 比较函数
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    // 2 生成随机函数
    public static int[] generatorRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    // 3 复制数组
    public static int[] copyArray(int[] arr) {
        if (arr == null)
            return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 4) 判断是否相等
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 5) 打印数组
    public static  void printArray(int[] arr) {
        if (arr == null)
            return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
