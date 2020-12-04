package xiaohaoAlgorithm.array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/3 23:28
 */
public class Intersection_Sort {
    /**
     * 假设两个数组有序，采用双指针
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int i, j, k;
        i = j = k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }

        return Arrays.copyOf(nums1, k);
    }

    public static void main(String[] args) {
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};

        int[] num3 = intersect(num1, num2);
        for (int i = 0; i < num3.length; i++) {
            System.out.print(num3[i] + " ");
        }
    }
}
