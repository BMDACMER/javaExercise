package xiaohaoAlgorithm.array;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/6 11:15
 * 283. 移动零
 */
public class RemoveZero {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int countZero = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            } else {
                countZero++;
            }
        }

        while (countZero != 0) {
            nums[nums.length - countZero] = 0;
            countZero--;
        }
    }

    /**
     *  方法二  思路来自于RemoveElement
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

    }
}
