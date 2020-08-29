package ��ײָ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 11:16
 *
 * 15 ����֮��
 * https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 *
 * ˼·��
 * 1������
 * 2������˫ָ�룬�̶�һ��Ԫ��num[i]����second��third�ֱ�ָ��ǰ����Ԫ�ص���һ���ڵ㣨��ߣ�������ĩ��λ��
 * 3��ȥ��    ������ʵ���ͬ��Ԫ��Ҳ��num[second] = num[second-1]������second������
 *           ����  num[third] = num[third+1]����third������
 *
 *          ������num[first] + num[second] + num[third] = 0ʱ���� second++.third--;  �����ظ���������
 */
public class ����֮�� {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        // 1 ����
        Arrays.sort(nums);

        // 2 ����˫ָ�룬�̶�һ��Ԫ��num[i]����second��third�ֱ�ָ��ǰ����Ԫ�ص���һ���ڵ㣨��ߣ�������ĩ��λ��
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // ��һ��Ԫ�ض�����0  ����������ٿ�����
            if (nums[i] > 0) return ans;

            // ��һ��Ԫ�� ȥ���ظ����
            if (i > 0 && nums[i] == nums[i - 1]) 
                continue;
            
            int target = -nums[i];
            int second = i + 1;   // ָ��ǰԪ�ص���һ��λ��
            int third = n - 1;   //  ָ���������һ��λ�ã����߶����м俿£

            while (second < third) {
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);

                    // ˫ָ�����м俿£
                    second++;
                    third--;

                    // �ڶ�������λ�� ȥ��
                    while (second < third && nums[second] == nums[second - 1]) second++;
                    while (second < third && nums[third] == nums[third + 1]) third--;
                } else if (nums[second] + nums[third] < target) {
                    second++;
                } else {
                    third--;
                }

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ����֮�� m = new ����֮��();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0,0,0};
        System.out.println(m.threeSum(nums));
    }
}
