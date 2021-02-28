package guohaoAlgorithm.springoffer.genshuixue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author guohao
 * @Date 2021/2/28 19:39
 * @Version 1.0
 *
 * 求中位数
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 输入奇数个整数，求中位数
 *
 *
 *
 * 输入描述
 * 第一行输入一个正整数，代表数组的长度n
 *
 * 第二行输入n个整数，代表数组中的n个元素
 *
 * 输出描述
 * 第一行包含一个整数，代表数组的正整数
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        int mid = nums.length / 2;
        System.out.println(nums[mid]);
    }

}
