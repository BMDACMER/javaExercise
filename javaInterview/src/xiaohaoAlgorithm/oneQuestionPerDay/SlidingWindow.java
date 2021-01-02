package xiaohaoAlgorithm.oneQuestionPerDay;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/2 10:02
 *
 * 239. 滑动窗口最大值
 */
public class SlidingWindow {
    // 暴力算法  提交时 49/60
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();   // 存放最终的最大值   结果

        while (index < n) {
            if (queue.size() < k) {
                queue.offer(nums[index]);
            }else {
                result.add(findMaxValue(queue));
                queue.pollFirst();
                queue.offerLast(nums[index]);
            }
            index++;
        }
        // 对最后的一组队列的元素排序
        result.add(findMaxValue(queue));

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private int findMaxValue(LinkedList<Integer> queue) {
        int maxValue = Integer.MIN_VALUE;   // 记录滑动窗口里 最大元素值
        for (int q : queue) {
            if (maxValue < q)
                maxValue = q;
        }
        return maxValue;
    }*/


    // 优化算法
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindow s = new SlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] window = s.maxSlidingWindow(nums, 3);
        for (int w : window) {
            System.out.print(w + " ");
        }
    }
}


class MonotonicQueue{
    private LinkedList<Integer> q = new LinkedList<>();

    public void push(int n) {
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        q.addLast(n);
    }

    public int max() {
        return q.getFirst();
    }

    public void pop(int n) {
        if (n == q.getFirst())
            q.pollFirst();
    }
}
