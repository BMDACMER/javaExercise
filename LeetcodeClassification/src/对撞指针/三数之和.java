package 对撞指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 11:16
 *
 * 15 三数之和
 * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 *
 * 思路：
 * 1、排序
 * 2、采用双指针，固定一个元素num[i]，让second和third分别指向当前遍历元素的下一个节点（左边）和数组末端位置
 * 3、去重    如果访问到相同的元素也即num[second] = num[second-1]，则让second往后移
 *           或者  num[third] = num[third+1]，让third往左移
 *
 *          当满足num[first] + num[second] + num[third] = 0时，则 second++.third--;  继续重复上述操作
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        // 1 排序
        Arrays.sort(nums);

        // 2 采用双指针，固定一个元素num[i]，让second和third分别指向当前遍历元素的下一个节点（左边）和数组末端位置
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 第一个元素都大于0  后面就无需再考虑了
            if (nums[i] > 0) return ans;

            // 第一个元素 去掉重复情况
            if (i > 0 && nums[i] == nums[i - 1]) 
                continue;
            
            int target = -nums[i];
            int second = i + 1;   // 指向当前元素的下一个位置
            int third = n - 1;   //  指向数组最后一个位置，两边都往中间靠拢

            while (second < third) {
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);

                    // 双指针向中间靠拢
                    second++;
                    third--;

                    // 第二、三个位置 去重
                    while (second < third && nums[second] == nums[second - 1]) second++;
                    while (second < third && nums[third] == nums[third + 1]) third--;
                } else if (nums[second] + nums[third] < target) {
                    second++;
                } else {
                    third--;
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        三数之和 m = new 三数之和();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0,0,0};
        System.out.println(m.threeSum(nums));
    }
}
