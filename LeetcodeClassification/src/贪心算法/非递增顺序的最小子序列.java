package ̰���㷨;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 10:53
 * 1403 �ǵ���˳�����С������
 * https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 */
public class �ǵ���˳�����С������ {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;   // �����Ԫ��֮��
        int subSum = 0;  // �����и�Ԫ��֮��
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
