package 百度;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/3 20:49
 * 3 走台阶
 *
 * 采用滑动窗口 hashset
 */
public class Main3 {

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums.length < 2) return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int count = 0;  // 统计最终结果
            // 步伐种类
            int[] arrM = new int[m];
            for (int i = 0; i < m; i++) {
                arrM[i] = i + 1;
            }



        }
    }

}
