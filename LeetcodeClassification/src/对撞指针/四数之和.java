package 对撞指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 15:01
 * 18 四数之和
 * https://leetcode-cn.com/problems/4sum/solution/javaban-ben-you-3sumgai-dong-by-wag-1/
 *
 * 思路: 在15 三数之和的基础上 再多一个循环即可
 */
public class 四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;

        // 1 排序
        Arrays.sort(nums);

        // 2 采用双指针，固定一个元素num[i]，让second和third分别指向当前遍历元素的下一个节点（左边）和数组末端位置
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 相对于三数之和 这里增加一重循环
            for (int j = i + 1; j < n; j++) {
                // 第一个元素 去掉重复情况
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int second = j + 1;   // 指向当前元素的下一个位置
                int third = n - 1;   //  指向数组最后一个位置，两边都往中间靠拢

                while (second < third) {
                    int temp = nums[i] + nums[j] + nums[second] + nums[third];
                    if (temp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);

                        // 双指针向中间靠拢
                        second++;
                        third--;

                        while (second < third && nums[second] == nums[second - 1]) second++;
                        while (second < third && nums[third] == nums[third + 1]) third--;
                    } else if (temp < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        四数之和 m = new 四数之和();
//        int[] nums ={1, 0, -1, 0, -2, 2};
        int[] nums ={1,-2,-5,-4,-3,3,3,5};
        System.out.println(m.fourSum(nums,-11));
    }
}
