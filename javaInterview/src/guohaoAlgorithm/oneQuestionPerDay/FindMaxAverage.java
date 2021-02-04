package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/4 9:06
 *
 * 643. ���������ƽ���� I  --- easy
 * ���� n ���������ҳ�ƽ��������ҳ���Ϊ k �����������飬����������ƽ������
 *
 *
 *
 * ʾ����
 *
 * ���룺[1,12,-5,-6,50,3], k = 4
 * �����12.75
 * ���ͣ����ƽ���� (12-5-6+50)/4 = 51/4 = 12.75
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0.0;

        // ����Ҫ��  k <= n
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
