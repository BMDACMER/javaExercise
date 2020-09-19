package 剑指offer;

import java.net.InetAddress;
import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/17 17:32
 * 59 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class 滑动窗口的最大值59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        滑动窗口的最大值59 m = new 滑动窗口的最大值59();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 2;
        System.out.println(m.maxSlidingWindow(nums, k));
    }
}
