package lintcode.stock;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/3 21:58
 *
 * 560. 给定一个整数数组和一个整数k，您需要找到总和等于k的连续子数组的总数。
 */
public class SubarrySumEqualsK {
    // 暴力法
    /**
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    } */

    // 高效算法
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;   // 统计次数
        int sum = 0;  // 统计子数组之和
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);  // 初始化
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                cnt += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }
}
