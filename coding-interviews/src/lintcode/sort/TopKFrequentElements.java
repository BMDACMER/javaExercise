package lintcode.sort;

import dataStructure.数据结构与算法之美.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/8 22:58
 * <p>
 * 347. 前 K 个高频元素
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] arr = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= k) {
                arr[index++] = entry.getKey();
            }
        }
        return arr;
    }
}
