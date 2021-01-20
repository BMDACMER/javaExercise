package guohaoAlgorithm.dynamic;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/20 21:28
 *
 * 740. 删除与获得点数
 *
 * 动态规划
 */
public class DeleteAndEarn {

    /*// 非动态规划
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];

        int ans, pre = Integer.MIN_VALUE;  // 用来消除重复数据
        for (int i = 0; i < n; i++) {
            if (pre == nums[i]) continue;
            pre = nums[i];

            ans = nums[i];
            int left = nums[i] - 1, right = nums[i] + 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    map.put(nums[j], map.getOrDefault(nums[j],0) + 1);
                    queue.offer(nums[j]);
                }
            }

            while (!queue.isEmpty()) {
                while (map.containsKey(left) && map.get(left) != 0) {
                    map.put(left, map.get(left) - 1);
                    queue.remove(left);
                }
                while (map.containsKey(right) && map.get(right) != 0) {
                    map.put(right, map.get(right) - 1);
                    queue.remove(right);
                }

                if (!queue.isEmpty()) {
                    int tmp = queue.poll();
                    ans += tmp;
                    left = tmp - 1;
                    right = tmp + 1;
                }
            }
            dp[i] = ans;
        }

        // 寻找dp中最大的元素
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/

    /**
     * 动态规划   仿造打家劫舍
     * 参考：https://leetcode-cn.com/problems/delete-and-earn/solution/ru-guo-ni-li-jie-liao-da-jia-jie-she-zhe-ti-ni-ken/
     * @param
     */
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        // 构造新数组  转换成 打家劫舍问题
        // 寻找最大值
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max + 1];
        int [] help = new int[max + 1];
        for (int num : nums) {
            help[num]++;
        }

        dp[0] = 0;
        dp[1] = help[1];
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + help[i] * i);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        DeleteAndEarn d = new DeleteAndEarn();
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(d.deleteAndEarn(nums));
    }
}
