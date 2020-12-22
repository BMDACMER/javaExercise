package xiaohaoAlgorithm.stack;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/22 21:56
 *
 * 503. 下一个更大元素 II
 */
public class NextGreaterElementsII {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n])
                stack.pop();
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementsII test = new NextGreaterElementsII();
        int[] nums = {1,2,1};
        int[] ints = test.nextGreaterElements(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
