package guohaoAlgorithm.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/4 9:43
 */
public class MaxSlidingWindow {

    /*// 方法一   分形成窗口时/未形成窗口  -- 11ms  击败86.81%
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        LinkedList<Integer> q = new LinkedList<>();
        int n = nums.length;
        // 未形成窗口时
        for (int i = 0; i < k && i < n; i++) {
            while (!q.isEmpty() && q.peekLast() < nums[i])
                q.pollLast();
            q.addLast(nums[i]);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = q.peekFirst();
        int index = 1;
        // 形成窗口时
        for (int i = k; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() == nums[i - k]) {
                q.pollFirst();
            }
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }
            q.addLast(nums[i]);
            ans[index++] = q.peekFirst();
        }

        return ans;
    }*/

    // 方法二： 构造函数
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicCQueue window = new MonotonicCQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}

class MonotonicCQueue{

    LinkedList<Integer> q = new LinkedList<>();

    public void push(int n) {
        while (!q.isEmpty() && q.peekLast() < n) {
            q.pollLast();
        }
        q.addLast(n);
    }

    public void pop(int n) {
        if (n == q.getFirst()) {
            q.removeFirst();
        }
    }

    public int max() {
        return q.getFirst();
    }
}
