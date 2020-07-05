package lintcode.doublepointer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/5 14:15
 *
 * 88. 合并两个有序数组
 *
 * 从后往前遍历
 */
public class MergerSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int merge = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while (len1 >= 0 && len2 >= 0) {
            if (nums1[len1] >= nums2[len2]) {
                nums1[merge--] = nums1[len1--];
            } else {
                nums1[merge--] = nums2[len2--];
            }
        }

        while (len1 >= 0) {
            nums1[merge--] = nums1[len1--];
        }
        while (len2 >= 0) {
            nums1[merge--] = nums2[len2--];
        }

    }
}
