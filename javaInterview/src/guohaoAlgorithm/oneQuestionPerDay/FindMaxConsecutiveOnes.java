package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/15 9:02
 * @Version 1.0
 *
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int maxCount = Integer.MIN_VALUE, right = 0, count = 0;
        while (right < n) {
            count++;
            right++;
            if (right < n && nums[right] == nums[right - 1]) {
                count++;
            }else if (right < n){
                count = 0;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes f = new FindMaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1};
        System.out.println(f.findMaxConsecutiveOnes(nums));
    }
}
