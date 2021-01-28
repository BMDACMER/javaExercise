package guohaoAlgorithm.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 19:44
 * <p>
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        HashMap<Integer, Integer> map = nextGreaterElementHelper(nums2);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    private HashMap<Integer, Integer> nextGreaterElementHelper(int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        return map;
    }

    /**
     * 参考 P267
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElementModule(int[] nums) {
        int[] ans = new int[nums.length];   // 存放答案
        Stack<Integer> stack = new Stack<>();
        // 从后往前遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(ans[i]);
        }
        return ans;
    }
}
