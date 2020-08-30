package ��������;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 14:25
 *
 * 220. �����ظ�Ԫ�� III
 *
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class �����ظ�Ԫ��III {
    /**
     * ����һ�������㷨  ͨ�� ��ʱ703 ms�������� Java �ύ�л�����5.07%���û�
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) return false;

        int count = 0;
        long tt = t;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(i - j) <= k && Math.abs(((long)nums[i] - (long)nums[j])) <= tt)
                    count++;
            }
        }
        return count > 0;
    }

    /**
     * �������� ɢ�б�  + Ͱ
     * �ο���https://leetcode-cn.com/problems/contains-duplicate-iii/solution/marvelzhong-deng-de-xue-xi-bi-ji-220-by-tyanyoneca/
     * ʱ�临�Ӷȣ���Խ93%��java�û�
     */

    private int sz;//Ͱ��С

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(t < 0)    return false; //����ֵ������Ϊ��
        sz = t + 1;
        Map<Integer, Long> map = new HashMap<>(); //��ϣ��Ͱ��ӳ�䵽ֵ��ֵ��Long��ֹ���
        for(int i = 0; i < nums.length; i++)
        {
            int key = getID(nums[i]); //�õ�Ͱ��
            if(map.containsKey(key)) // ͬһ��Ͱ����ľ���ֵ��Ȼ����Ҫ��
                return true;
            if(map.containsKey(key - 1) && Math.abs(map.get(key - 1) - nums[i]) <= t) //�������Ͱ
                return true;
            if(map.containsKey(key + 1) && Math.abs(map.get(key + 1) - nums[i]) <= t)
                return true;
            map.put(key, (long)nums[i]); //����ֵ����Ͱ��
            if(i >= k)    map.remove(getID(nums[i - k]));//Ϊ��ʼ�������±�Ĳ�ľ���ֵҪ��
        }
        return false;
    }
    /*����Ͱ��*/
    private int getID(int num) {
        return (num < 0) ? num / sz - 1 : num / sz; //��ֹ0��Ͱͬʱ���������������ж�
    }

}

/*
[2147483647,-2147483647]
1
2147483647
 */