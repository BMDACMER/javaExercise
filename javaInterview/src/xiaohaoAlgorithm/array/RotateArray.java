package xiaohaoAlgorithm.array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/5 23:40
 *
 * ԭ����ת����(189)
 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
 */
public class RotateArray {
    /**
     * 1���Ȱ�����Ԫ�ط�ת
     * 2����ǰk%len��Ԫ�ط�ת���� len - k��Ԫ�ط�ת
     * 3���������鷴ת
     * @param nums
     * @return
     */
    public static int[] rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k % nums.length - 1);
        reverse(nums, k % nums.length, nums.length - 1);
        return nums;
    }

    public static int[] reverse(int[] arr, int start, int end) {
        int temp;
        for (int i = start, j = end; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] res = rotate(nums, k);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
