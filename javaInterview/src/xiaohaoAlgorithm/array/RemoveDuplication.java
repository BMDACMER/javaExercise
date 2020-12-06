package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/6 11:04
 *
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplication {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int i = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] != nums[j+1]) {
                nums[i++] = nums[j];
            }
        }
        nums[i] = nums[nums.length - 1];
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
