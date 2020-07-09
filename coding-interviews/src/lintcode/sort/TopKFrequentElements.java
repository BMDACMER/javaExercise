package lintcode.sort;


import java.util.*;

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

        // 构建最大堆
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> (map.get(o2) - map.get(o1)));
        for (int key : map.keySet()) {
            queue.add(key);
        }

        int[] ans = new int[k];
        int index = 0;
        while (index < k) {
            ans[index++] = queue.poll();
        }

        return ans;
    }
}
