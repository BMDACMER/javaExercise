package ���ֲ���;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 17:21
 * 540 ���������еĵ�һԪ��
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 *
 *
 */
public class ���������еĵ�һԪ�� {
    /**
     * ����ɢ�б�   key--Ԫ�أ�value-���ִ���
     * �ҳ�valueΪ1�ķ���key����   ----  ���Ӷ�Ϊ O(n) s
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;  // ��Ŀ�м���һ������  ���Դ˴�����ִ��
    }

    /**
     * ��Ϊ���������飬���Կ����ö��ַ���˼·��ȡ�����м���������м������±�Ϊ������˵��ǰ��Ԫ�صĸ���Ϊ������
     * ż����ʣ�����Ϊż��������ʱ����nums[h]����[h+1],Ψһ������ǰh-1,��֮���ں�h+1��
     * ż��ʱ����nums[h]����[h+1]��Ψһ�����ں�h+2,��֮����ǰh.(����Ҫ��֤ʣ�����Ԫ�ظ�������)
     *
     * ���ߣ�qiu-offer-3
     * ���ӣ�https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/java-er-fen-fa-0msji-bai-liao-10000-by-qiu-offer-3/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     */
    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if ((middle&1)== 1) { // �±�Ϊ����
                if (nums[middle] == nums[middle+1]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {   // �±�Ϊż��
                if (nums[middle] == nums[middle+1]) {
                    left = middle + 2;
                } else {
                    right = middle - 1;
                }
            }

        }
        return nums[left];
    }

}
