package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/8 9:34
 *
 * 189. 旋转数组
 */
public class Rotate {

    /**
     * 算法思路：先将所有数据反转，在将前k各数组反转，接着将剩余的len - k 个数组反转
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        rotateArray(nums, 0, len - 1);
        rotateArray(nums, 0, k % len - 1);
        rotateArray(nums, k % len, len - 1);
    }

    private void rotateArray(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return;
    }

    /**
     * 方法二： 时间复杂度为O(kn)
     * 空间复杂度为O(1)
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int tmp;
        for (int i = 0; i < k % len; i++) {
            tmp = nums[len - 1];  // 每次都记录数组中最后一个元素
            for (int j = len - 1; j >  0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

}
