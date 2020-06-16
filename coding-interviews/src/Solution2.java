import java.util.ArrayList;
import java.util.Collections;

/**
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * 思路：根据斐波那契的定义找出之前的所有数字，然后分别从前和从后找出和为给定值的数。
 * 再给定数字k，首先找理它最近的一个斐波那契数字，然后再剩下的数字前按照贪心算法求解，（貌似时间复杂度有点高）
 */
public class Solution2 {
    int count = 0;  // 统计最少数目
    public int findMinFibonacciNumbers(int k) {
        int[] arr = new int[45];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        for (int i = arr.length-1; i >= 0; i--) {
            if (k >= arr[i]) {
                k -= arr[i];
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.findMinFibonacciNumbers(645157245));
    }
}
