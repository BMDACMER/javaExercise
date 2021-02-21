package guohaoAlgorithm.oneQuestionPerDay;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Author guohao
 * @Date 2021/2/21 9:36
 * @Version 1.0
 *
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 */
public class LongestSubarray1438 {

    // 暴力算法   超时   56 / 60 个通过测试用例
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, maxLen, ans = 0;
        for (int i = 0; i < n; i++) {
            maxLen = 0;
            int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                // 在这里记录最小值和最大值
                maxValue = Math.max(maxValue, nums[j]);
                minValue = Math.min(minValue, nums[j]);
                if (Math.abs(maxValue - minValue) > limit) break;
                maxLen++;
            }
            ans = Math.max(ans, maxLen);
        }
        return ans;
    }

    // 滑动窗口   优化算法  TreeMap ---- 32.66% + 34.08%
    public int longestSubarray2(int[] nums, int limit) {
        int n = nums.length;
        int left = 0, right = 0, ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    // 滑动窗口   双端队列   93.43%+64.25%
    public int longestSubarray3(int[] nums, int limit) {
        int n = nums.length;
        LinkedList<Integer> maxV = new LinkedList<>();
        LinkedList<Integer> minV = new LinkedList<>();
        int left = 0, right = 0, ans = 0;
        while (right < n) {
            while (!maxV.isEmpty() && maxV.peekLast() < nums[right]) {
                maxV.pollLast();
            }
            while (!minV.isEmpty() && minV.peekLast() > nums[right]) {
                minV.pollLast();
            }
            maxV.offerLast(nums[right]);
            minV.offerLast(nums[right]);
            right++;
            while (!maxV.isEmpty() && !minV.isEmpty() && Math.abs(maxV.peekFirst() - minV.peekFirst()) > limit) {
                if (nums[left] == minV.peekFirst()) {
                    minV.pollFirst();
                }
                if (nums[left] == maxV.peekFirst()) {
                    maxV.pollFirst();
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubarray1438 test = new LongestSubarray1438();
//        int[] nums = {1,5,6,7,8,10,6,5,6};
        int[] nums = {8,2,4,7};
        System.out.println(test.longestSubarray2(nums, 4));
    }
}
