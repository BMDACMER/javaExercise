package guohaoAlgorithm.slidingwindow;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/3 8:41
 *
 * 480. 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 */
public class MedianSlidingWindow {

    /**
     * 双指针+滑动窗口 + 插入排序   会超时
     * @param
     * @param
     * @return
     */
    /*public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new double[]{};

       MonotonicQueue window = new MonotonicQueue();
       int n = nums.length;
       double[] ans = new double[n - k + 1];
       int index = 0;

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                // 先把窗口的前 k - 1 填满
                window.push(nums[i]);
            } else {
                // 窗口开始向前移动，移除新元素
                window.push(nums[i]);
                // 将窗口的中位数 记录在结果中
                ans[index++] = window.medium();
                // 移除最后的元素
                window.pop(nums[i - k + 1]);
            }
        }

        return ans;
    }*/

    // 暴力算法 直接sort
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < k; j++) {
                window[j] = nums[i + j];
            }
            Arrays.sort(window);
            if (k % 2 == 1) {
                ans[i] = window[k/2];
            }else {
                ans[i] = ((double)window[k/2 - 1] + (double) window[k/2] ) / 2.0;
            }
        }
        return ans;
    }

    // 击败88%的解法  参考：https://leetcode-cn.com/problems/sliding-window-median/
    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] window = new int[k];
        //添加初始值
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        //初始的快排，懒得写直接调用
        Arrays.sort(window);
        res[0] = getMid(window);
        //窗口滑动
        for (int i = 0; i < nums.length - k; i++) {
            //需要删除的数
            int index = search(window, nums[i]);
            //替换为需要插入的数
            window[index] = nums[i + k];
            //向后冒泡  替换后的index  如果比后面的大 则向后下沉
            while (index < window.length - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            //向前冒泡   如果比前面的小 则向前下沉
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            res[i + 1] = getMid(window);
        }
        return res;
    }

    //交换
    private void swap(int[] window, int i, int j) {
        int temp = window[i];
        window[i] = window[j];
        window[j] = temp;
    }

    //求数组的中位数
    private double getMid(int[] window) {
        int len = window.length;
        if (window.length % 2 == 0) {
            //避免溢出
            return window[len / 2] / 2.0 + window[len / 2 - 1] / 2.0;
        } else {
            return window[len / 2];
        }
    }

    //最简单的二分查找
    private int search(int[] window, int target) {
        int start = 0;
        int end = window.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (window[mid] > target) {
                end = mid - 1;
            } else if (window[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MedianSlidingWindow m = new MedianSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        double[] window = m.medianSlidingWindow(nums, 3);
        for (int i = 0; i < window.length; i++) {
            System.out.print(window[i] + " ");
        }
    }
}

/*
class MonotonicQueue {
    LinkedList<Integer> q = new LinkedList<>();

    // 在队尾添加元素 n  始终保持窗口有序
    void push(int n){
        // 为了保持窗口元素的有序性 得先排序
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty() && q.peekLast() > n) {
            stack.push(q.pollLast());
        }
        // 将当前元素存放到链表中
        q.addLast(n);
        // 将栈中的元素放到链表中
        while (!stack.isEmpty()) {
            q.addLast(stack.pop());
        }
    }

    // 返回中位数
    double medium() {
        // 返回的中位数 需要分两种情况：奇数和偶数
        int n = q.size();
        if (n % 2 == 1) {
            return q.get(n / 2 ); // 例如 5/2 + 1 = 3   下标从0开始 相当于2
        }else {
            return q.get(n/2 - 1) + (q.get(n/2) - q.get(n / 2 - 1)) / 2.0;
        }
    }

    // 移除窗口头元素
    void pop(int n) {
        for (int i = 0; i < q.size(); i++) {
            if (q.get(i).equals(n)) {
                q.remove(i);
                return;
            }
        }
    }
}
*/
