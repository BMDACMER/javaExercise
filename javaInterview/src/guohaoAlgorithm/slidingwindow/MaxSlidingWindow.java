package guohaoAlgorithm.slidingwindow;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 20:12
 *
 *  剑指 Offer 59 - I. 滑动窗口的最大值
 *
 *  https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {

    // 以下是错误方法
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return null;

        int n = nums.length;
        if (n <= k) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
            }
            return new int[]{max};
        } else {
            int[] res = new int[n - k + 1];
            int index = 0;
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            int i = 0;
            while (i < n - k + 1) {
                for (int j = i; j < i + k; j++) {
                    if (stack1.isEmpty()) {
                        stack1.push(nums[j]);
                    } else {  // stack1非空时
                        // 首先判断滑动窗口的首位元素与栈中的最大元素是否相等，若等 则移除
                        if (stack1.size() == k && stack1.peek() == nums[i]) {
                            stack1.pop();
                        }

                        if (stack1.peek() <= nums[j]) {
                            stack1.push(nums[j]);
                        } else {
                            while (!stack1.isEmpty() && stack1.peek() > nums[j]) {
                                stack2.push(stack1.pop());
                            }
                            // 将当前值入栈
                            stack1.push(nums[j]);
                            // 将stack2中的元素存放到stack1中
                            while (!stack2.isEmpty()) {
                                stack1.push(stack2.pop());
                            }
                        }
                    }
                }
                res[index++] = stack1.pop();
                i++;
            }

            return res;
        }
    }*/

    // 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return null;

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        Deque<Integer> q = new LinkedList<>();
        // 未形成窗口时
        for (int i = 0; i < k && i < n; i++) {
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.addLast(nums[i]);
        }
        ans[0] = q.peekFirst();
        // 形成窗口时
        for (int i = k; i < n; i++) {
            // 判断窗口的最左边元素与队列的最大值是否相等，若相等 则移除
            if (q.peekFirst() == nums[i - k]) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.addLast(nums[i]);
            ans[i-k+1] = q.peekFirst();
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow s = new MaxSlidingWindow();
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        s.maxSlidingWindow(nums, 5);
    }
}
