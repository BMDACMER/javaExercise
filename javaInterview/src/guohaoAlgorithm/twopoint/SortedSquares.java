package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 13:55
 *
 * 977. 有序数组的平方
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int index = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[index] = nums[i] * nums[i];
                index--;
                i++;
            } else {
                ans[index] = nums[j] * nums[j];
                index--;
                j--;
            }
        }
        return ans;
    }
}
