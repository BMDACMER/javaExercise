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

    /**
     * 思路：遍历数组中元素，记当前元素为num[i]，其相邻值num[i]-1, num[i-2]；将剩余元素存放到队列中
     * 如果当前元素的相邻元素在队列中，则将其从队列中全部删除（需要借助hashset，这样可以把多次出现的相同元素都删掉）
     * 如果队列不为空，从队列中取出一个元素，累加，并计算其相邻值，重复上述操作，直到队列为空。这样删除当前元素nums[i]，
     * 获得的点数存到ArrayList中，  依次遍历其他元素，最后取出最大点数，并返回。
     *
     * 经测试 [3,7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,4,7,6,10]这组数据一直过不了，请问错在哪里？
     * @param nums
     * @return
     */
    public int deleteAndEarn2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        ArrayList<Integer> dp = new ArrayList<>();

        int ans;
        HashSet<Integer> set = new HashSet<>();  // 用来消除重复数据
        for (int i = 0; i < n; i++) {
            // 避免相同元素重复计算  比如[2,2,2,3,4,4,5]  计算了依次2   后面再次遇到2就跳过  直来到3这个位置
            if (set.contains(i)) continue;
            set.add(i);

            ans = nums[i];
            int left = nums[i] - 1, right = nums[i] + 1;
            HashMap<Integer, Integer> map = new HashMap<>();   // map，-----> 用来辅助队列删除相同元素
            Deque<Integer> queue = new ArrayDeque<>();

            // 将除了当前元素外的其他元素都入队
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    map.put(nums[j], map.getOrDefault(nums[j],0) + 1);
                    queue.offer(nums[j]);
                }
            }

            while (!queue.isEmpty()) {
                // 移除队列中与当前元素相邻的元素  num[i] - 1
                while (map.containsKey(left) && map.get(left) != 0) {
                    map.put(left, map.get(left) - 1);
                    queue.remove(left);
                }
                // 移除队列中与当前元素相邻的元素  num[i] + 1
                while (map.containsKey(right) && map.get(right) != 0) {
                    map.put(right, map.get(right) - 1);
                    queue.remove(right);
                }

                // 如果队列不为空   为下一次操作做准备
                if (!queue.isEmpty()) {
                    // 取出队头元素
                    int tmp = queue.poll();
                    // 当前元素累加到结果ans中
                    ans += tmp;
                    // 当前元素的相邻元素
                    left = tmp - 1;
                    right = tmp + 1;
                }
            }
            dp.add(ans);
        }

        // 寻找dp中最大的元素
        int max = dp.get(0);
        for(int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }

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
        int[] nums = {3,7,10,5,2,4,8,9,9,4,9,2,6,4,6,5,4,7,6,10};
        System.out.println(d.deleteAndEarn2(nums));
    }
}
