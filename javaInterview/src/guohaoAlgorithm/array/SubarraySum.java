package guohaoAlgorithm.array;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/30 19:42
 *
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class SubarraySum {

    // 暴力算法 -- 前缀和
    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length < 1) return 0;
        int n = nums.length;
        int[] arr = new int[n + 1];
        // 统计nums的前缀和
        for (int i = 0; i < n; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }

        // 暴力算法
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == k)
                    ans++;
            }
        }
        return ans;
    }

    // 优化后的时间复杂度为O(n)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // base case
        map.put(0,1);

        int sun_i = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sun_i += nums[i];
            int sum0_j = sun_i - k;
            if (map.containsKey(sum0_j)) {
                ans += map.get(sum0_j);
            }
            map.put(sun_i, map.getOrDefault(sun_i, 0) + 1);
        }
        return ans;
    }



    public static void main(String[] args) {
        SubarraySum s = new SubarraySum();
        int[] nums = {1,1,1};
        System.out.println(s.subarraySum(nums, 2));
    }
}
