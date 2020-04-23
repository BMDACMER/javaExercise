package lintcode.offer;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * ������03�� �������ظ�������
 */
public class Test01 {
    // �����⣺ �ҳ����ظ�������
    public int findRepeatNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 1 ͳ��ÿ�����ֳ��ֵĴ���
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 2 ���س���һ�ε�����
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry entry : set) {
            if (entry.getValue().equals(1)) {
                return (int) entry.getKey();
            }
        }
        return -1;
    }

    // �ҳ�����������һ���ظ�������
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return nums[i];
        }
        return -1;  // û�ҵ�
    }
}
