package 滑动数组;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 13:58
 */
public class 存在重复元素II {

    /**
     * 方法一： 暴力算法  一一比较  时间复杂度为 O(n*n)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 1 异常处理
        if (nums.length < 2) return false;

        // 2
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]  && Math.abs(i - j)  <= k) {
                    count++;
                }
            }
        }

        return count > 0;
    }

    /**
     * 方法二： 采用散列表的形式  hashset   滑动窗口
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(min(n,k))
     */
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
        存在重复元素II m = new 存在重复元素II();
        int[] nums = {1,0,1,1};
        System.out.println(m.containsNearbyDuplicate2(nums, 2));
    }
}
