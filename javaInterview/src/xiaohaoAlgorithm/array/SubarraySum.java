package xiaohaoAlgorithm.array;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 15:17
 *
 * 560. 和为K的子数组
 */
public class SubarraySum {
    /**
     * 暴力算法
     * 思想：统计nums前i个子数组的和，然后用nums[j + 1] - nums[i]就是区间[i,j]之间的子数组和
     * 判断 子数组和与k的值  count++   返回即可
     * @param nums
     * @param k
     * @return
     */
   /* public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;  // 表示前0个元素的和为0，也即没有子数组  和肯定为0啦
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                if (sum[j] - sum[i] == k)
                    count++;
            }
        }
        return count;
    }*/


    /**
     * 优化算法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // map--> 子数组的和  以及出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // base case
        map.put(0,1);
        int sum_i = 0, sum_j = 0;
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum_i += nums[i];
            sum_j = sum_i - k;
            if (map.containsKey(sum_j)) {
                ans += map.get(sum_j);
            }
            map.put(sum_i, map.getOrDefault(sum_i,0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        SubarraySum s = new SubarraySum();
        int[] nums = {1,1,1,2};
        int k = 2;
        System.out.println(s.subarraySum(nums, k));
    }
}
