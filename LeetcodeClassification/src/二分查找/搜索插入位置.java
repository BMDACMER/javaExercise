package 二分查找;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 16:43
 *
 * 35 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {

        // 1 当数组为空时，直接将target插入，返回第一个位置
        if (nums.length < 1) {
            return 0;
        }

        // 2 当数组中有1个及以上元素时
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }

        // 走到这一步说明没查到，就需要进行插入操作
        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return n;   // 遍历完在尾端插入
    }

    public static void main(String[] args) {
        搜索插入位置 m = new 搜索插入位置();
        int[] nums = {1};
        System.out.println(m.searchInsert(nums, 1));
    }
}
