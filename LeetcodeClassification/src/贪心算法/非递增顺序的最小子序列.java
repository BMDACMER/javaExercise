package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 10:53
 * 1403 非递增顺序的最小子序列
 * https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 */
public class 非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;   // 数组各元素之和
        int subSum = 0;  // 子序列各元素之和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; --i) {
            list.add(nums[i]);
            subSum += nums[i];
            sum -= nums[i];
            if (subSum > sum)
                break;
        }
        return list;
    }
}
