package ��ײָ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 15:01
 * 18 ����֮��
 * https://leetcode-cn.com/problems/4sum/solution/javaban-ben-you-3sumgai-dong-by-wag-1/
 *
 * ˼·: ��15 ����֮�͵Ļ����� �ٶ�һ��ѭ������
 */
public class ����֮�� {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;

        // 1 ����
        Arrays.sort(nums);

        // 2 ����˫ָ�룬�̶�һ��Ԫ��num[i]����second��third�ֱ�ָ��ǰ����Ԫ�ص���һ���ڵ㣨��ߣ�������ĩ��λ��
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // ���������֮�� ��������һ��ѭ��
            for (int j = i + 1; j < n; j++) {
                // ��һ��Ԫ�� ȥ���ظ����
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int second = j + 1;   // ָ��ǰԪ�ص���һ��λ��
                int third = n - 1;   //  ָ���������һ��λ�ã����߶����м俿£

                while (second < third) {
                    int temp = nums[i] + nums[j] + nums[second] + nums[third];
                    if (temp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);

                        // ˫ָ�����м俿£
                        second++;
                        third--;

                        while (second < third && nums[second] == nums[second - 1]) second++;
                        while (second < third && nums[third] == nums[third + 1]) third--;
                    } else if (temp < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        ����֮�� m = new ����֮��();
//        int[] nums ={1, 0, -1, 0, -2, 2};
        int[] nums ={1,-2,-5,-4,-3,3,3,5};
        System.out.println(m.fourSum(nums,-11));
    }
}
