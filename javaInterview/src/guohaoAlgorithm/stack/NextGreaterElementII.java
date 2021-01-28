package guohaoAlgorithm.stack;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 19:54
 *
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek(); // 当前元素身后的第一个高个
            stack.push(nums[i % n]);  // 进队，接受之后的身高判定
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementII n = new NextGreaterElementII();
        int[] nums = {1,2,1};
        int[] ints = n.nextGreaterElements(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
