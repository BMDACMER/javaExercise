package 牛客网.算法初级班;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/30 11:35
 *
 * 荷兰国旗问题
 *
 * 给定一个数组arr和一个数num，请把小于num是数放在数组的左边，等于num的数放在数组的中间，
 * 大于num是数放在数组的右边，要求额外空间为o(1),时间为o(n)
 */
public class Code_08_NetherlandsFlag {

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null)
            return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 核心代码
    public static void rotate(int[] arr, int num) {
        if (arr == null || arr.length < 1) return;
        int l = -1, current = 0, r = arr.length;
        while (current < r) {
            if (arr[current] < num) {
                swap(arr, ++l, current++);
            } else if (arr[current] == num) {
                current++;
            } else {
                swap(arr, current, --r);
            }
        }
    }

    public static void main(String[] args) {
        int[] test = generateArray();
        printArray(test);
        rotate(test, 15);
        System.out.println("排序外后：");
        printArray(test);
    }
}

