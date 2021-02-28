package guohaoAlgorithm.springoffer.genshuixue;

import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 19:09
 * @Version 1.0
 * 1、二分查找
 *
 * 查找定位
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个已排序的数组和一个目标值，如果在数组里面找到这个值则返回下标，如果没有，则返回该值插入数组后的位置下标。时间复杂度需要<=O(log n)
 *
 *
 *
 * 输入描述
 * 第一行输入一串整数，代表一个已排序的数组
 *
 * 第二行输入一个整数，代表目标值
 *
 * 输出描述
 * 输出一行，包含一个整数，代表目标值在数组中位置的下标
 *
 *
 * 样例输入
 * 1 3 5 6
 * 5
 * 样例输出
 * 2
 */
public class Main1 {

    public static int help(int[] nums, int number) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (number == nums[mid]) {
                return mid;
            }else if (number > nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        int[] nums = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            nums[i] = sb.charAt(i) - '0';
        }
        int k = scan.nextInt();
        System.out.println(help(nums, k));
    }
}
