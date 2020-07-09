package lintcode.sort;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/9 10:30
 * <p>
 * 75. ��ɫ����
 * <p>
 * ����һ��������ɫ����ɫ����ɫ��һ��?n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
 * <p>
 * �����У�����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sort-colors
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SortColor {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;  // ��������
        int i = start;
        int j = end;
        if (i < j) {
            int tmp = nums[i];
            while (i < j) {
                while (i < j && nums[j] >= tmp) j--;
                nums[i] = nums[j];
                while (i < j && nums[i] <= tmp) i++;
                nums[j] = nums[i];
            }
            nums[i] = tmp;
        }
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }
}
