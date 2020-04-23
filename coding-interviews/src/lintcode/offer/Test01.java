package lintcode.offer;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 面试题03： 数组中重复的数字
 */
public class Test01 {
    // 变形题： 找出不重复的数字
    public int findRepeatNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 1 统计每个数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 2 返回出现一次的数字
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry entry : set) {
            if (entry.getValue().equals(1)) {
                return (int) entry.getKey();
            }
        }
        return -1;
    }

    // 找出数组中任意一个重复的数字
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return nums[i];
        }
        return -1;  // 没找到
    }
}
