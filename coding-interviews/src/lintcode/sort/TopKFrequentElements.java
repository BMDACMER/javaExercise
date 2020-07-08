package lintcode.sort;

import dataStructure.���ݽṹ���㷨֮��.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/8 22:58
 * <p>
 * 347. ǰ K ����ƵԪ��
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
