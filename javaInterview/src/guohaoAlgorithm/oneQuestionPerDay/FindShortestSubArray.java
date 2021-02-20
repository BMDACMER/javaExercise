package guohaoAlgorithm.oneQuestionPerDay;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author guohao
 * @Date 2021/2/20 7:53
 * @Version 1.0
 *
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 */
public class FindShortestSubArray {

    /**
     * 思路： 将数组中的元素映射到 包含每个元素出现次数、该元素首次出现的位置、该元素最后出现的位置的 长度为3的数组中
     *  统计元素中出现频率最高的元素 如果频率相同则比较首末位置差最小的元素，返回其长度
     *
     *
     *  执行用时： 15 ms, 在所有 Java 提交中击败了 87.60%的用户
     *  内存消耗： 42.8 MB , 在所有 Java 提交中击败了 36.94% 的用户
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1,i,i});
            }
        }

        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (maxNum < entry.getValue()[0]) {
                maxNum = entry.getValue()[0];
                minLen = entry.getValue()[2] - entry.getValue()[1] + 1;
            } else if (maxNum == entry.getValue()[0]){
                // 频率相同时  比较长度最小的
                minLen  = Math.min(minLen, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        return minLen;
    }
}
