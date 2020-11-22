package ţ����.�㷨������;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/30 11:35
 *
 * ������������
 *
 * ����һ������arr��һ����num�����С��num���������������ߣ�����num��������������м䣬
 * ����num��������������ұߣ�Ҫ�����ռ�Ϊo(1),ʱ��Ϊo(n)
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

    // ���Ĵ���
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
        System.out.println("�������");
        printArray(test);
    }
}

