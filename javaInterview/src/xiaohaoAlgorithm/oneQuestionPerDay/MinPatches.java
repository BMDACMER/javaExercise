package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/29 9:10
 *
 * 330. 按要求补齐数组
 */
public class MinPatches {

    /**
     * 思路：先统计处 nums中的所有数字，存放在hashset中，然后从中取出组合得出新数放到hashset中，
     * 在遍历[1,n]之间未出现的数字，从小到达访问，加入hashset中，重新计算新数，与剩下的[1,n]之间的数对比
     * （将[1,n]之间剩下的数也放到hashset中，便于快速访问），最后统计最小次数
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        // 异常处理
        if (nums.length >= n) return 0;

        Set<Long> visited = new HashSet<>(); // 存放nums中数字
        Queue<Long> notVisited = new ArrayDeque<>();  // 存放 不能由nums中元素组合得到的数字

        int minCount = 0; // 最少需要补充的数字
        for (int num : nums) {
            visited.add((long) num);
        }


        // 组合nums数组中的数字
        for (int i = 0; i < nums.length; i++) {
            long tmp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                tmp += nums[j];
                if (!visited.contains(tmp)) {
                    visited.add(tmp);
                }
            }
        }

        // 判断不在nums数组中的元素 还剩多少
        for (long i = 1; i <= n; i++) {
            if (!visited.contains(i))
                notVisited.add(i);
        }

        // 统计需要添加的最少次数
        while (!notVisited.isEmpty()) {
            long num = notVisited.poll();
            // 注意  notVisited是里面的元素有序的, 题目中说是排好序的数字

            if (!visited.contains(num)) {
                visited.add(num);
                minCount++;
                // 各个元素在重新计算新值 重新加入到 visited集合中
                Long[] visitedArr = new Long[visited.size()];
                visited.toArray(visitedArr);

                for (int i = 0; i < visitedArr.length; i++) {
                    long tmp = visitedArr[i];
                    for (int j = i + 1; j < visitedArr.length; j++) {
                        tmp += visitedArr[j];
                        if (tmp <= n && !visited.contains(tmp)) {
                            visited.add(tmp);
                        }
                    }
                }
            }

        }

        return minCount;
    }

    /**
     * 方法二：高效算法
     * 参考：https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
     *
     */
    public int minPatches2(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        MinPatches m = new MinPatches();
        int[] nums = {1,2,31,33};
        int n = 2147483647;  // 2^31 - 1
        System.out.println(m.minPatches2(nums,n));
    }
}
