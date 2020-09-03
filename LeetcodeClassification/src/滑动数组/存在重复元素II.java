package ��������;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 13:58
 */
public class �����ظ�Ԫ��II {

    /**
     * ����һ�� �����㷨  һһ�Ƚ�  ʱ�临�Ӷ�Ϊ O(n*n)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 1 �쳣����
        if (nums.length < 2) return false;

        // 2
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]  && Math.abs(i - j)  <= k) {
                    count++;
                }
            }
        }

        return count > 0;
    }

    /**
     * �������� ����ɢ�б����ʽ  hashset   ��������
     * ʱ�临�Ӷ�Ϊ O(n)
     * �ռ临�Ӷ�Ϊ O(min(n,k))
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums.length < 2) return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }



    public static void main(String[] args) {
        �����ظ�Ԫ��II m = new �����ظ�Ԫ��II();
        int[] nums = {1,0,1,1};
        System.out.println(m.containsNearbyDuplicate2(nums, 2));
    }
}
