package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/4 9:06
 *
 * 643. 子数组最大平均数 I  --- easy
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0.0;

        // 题意要求  k <= n
        int n = nums.length;
        double sum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return 1.0 * maxSum / k;
    }
}
