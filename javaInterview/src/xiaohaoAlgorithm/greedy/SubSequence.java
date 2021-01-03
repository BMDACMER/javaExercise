package xiaohaoAlgorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 13:53
 *
 * 1403. 非递增顺序的最小子序列
 */
public class SubSequence {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // 求和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 排序
        Arrays.sort(nums);
        // 比较   sub = 最大子元素的和  大于 剩余元素之和
        int sub = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sub += nums[i];
            sum -= nums[i];
            list.add(nums[i]);
            if (sub > sum) {
                break;
            }

        }

        return list;
    }

    public static void main(String[] args) {
        SubSequence s = new SubSequence();
        int[] nums = {4,4,7,6,7};
        s.minSubsequence(nums);
    }

}
