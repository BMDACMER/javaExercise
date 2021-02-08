package guohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/8 10:45
 *
 * ��ָ Offer 42. ���������������
 * ����һ���������飬�����е�һ������������������һ�������顣������������ĺ͵����ֵ��
 *
 * Ҫ��ʱ�临�Ӷ�ΪO(n)��
 *
 *
 *
 * ʾ��1:
 *
 * ����: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 *
 *
 * ��ʾ��
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class MaxSubArray {

    /**
     * dp[i] ---- ��nums[i]��β������������
     * base case dp[0] = nums[0]
     * ״̬ת�Ʒ��̣� dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    // ״̬ѹ��
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int dp_0 = nums[0], dp_1, res = dp_0;
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }
        return res;
    }
}
