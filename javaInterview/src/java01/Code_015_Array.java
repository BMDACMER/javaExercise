package java01;

import java.util.Arrays;

/**
 * 并行处理数组
 */
public class Code_015_Array {
    public static void main(String[] args) {
        int[] arr = {1,5,8,3,19,40,6};
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }
}
