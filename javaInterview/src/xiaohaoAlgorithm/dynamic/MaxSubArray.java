package xiaohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/11 10:55
 * ��ָ Offer 42. ���������������
 */
public class MaxSubArray {

    /**
     *  ʱ�临�Ӷ�Ϊ��O(n)
     *  �ռ临�Ӷ�Ϊ��O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        // dp[i] --- ��nums[i]��β�������������
        int[] dp = new int[n];
        int maxSum;
        maxSum = dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    /**
     * ������ʱ�临�Ӷ�Ϊ��O(n)
     * �ռ临�Ӷ�Ϊ��O(1)  --- ��Ϊdp[i]ֻ��dp[i-1]��أ����� ѹ��״̬ ��ʡ�ռ�
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        int dp_0 = nums[0], dp_1;
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            maxSum = Math.max(maxSum, dp_0);
        }
        return maxSum;
    }
}
