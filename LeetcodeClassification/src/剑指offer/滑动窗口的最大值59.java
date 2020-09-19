package ��ָoffer;

import java.net.InetAddress;
import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/17 17:32
 * 59 �������ڵ����ֵ
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class �������ڵ����ֵ59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // δ�γɴ���
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // �γɴ��ں�
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
        �������ڵ����ֵ59 m = new �������ڵ����ֵ59();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 2;
        System.out.println(m.maxSlidingWindow(nums, k));
    }
}
