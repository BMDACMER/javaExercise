package ���ֲ���;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 16:43
 *
 * 35 ��������λ��
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У�
 * ���������ᱻ��˳������λ�á�
 *
 * ����Լ������������ظ�Ԫ�ء�
 */
public class ��������λ�� {
    public int searchInsert(int[] nums, int target) {

        // 1 ������Ϊ��ʱ��ֱ�ӽ�target���룬���ص�һ��λ��
        if (nums.length < 1) {
            return 0;
        }

        // 2 ����������1��������Ԫ��ʱ
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }

        // �ߵ���һ��˵��û�鵽������Ҫ���в������
        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return n;   // ��������β�˲���
    }

    public static void main(String[] args) {
        ��������λ�� m = new ��������λ��();
        int[] nums = {1};
        System.out.println(m.searchInsert(nums, 1));
    }
}
