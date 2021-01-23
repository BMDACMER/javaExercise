package guohaoAlgorithm.dynamic;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 11:38
 *
 * ��ָ Offer 42. ���������������
 *
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/
 * ����: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 */
public class MaxSubArray {

    // dp[i] --- ��nums[i]���������������������
    // dp[0] = nums[0];
    // Ҫô�Գ�һ�� Ҫô��֮ǰ�ĺϲ�    dp[i] = max(num[i], dp[i-1] + nums[i])
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // �Ż� ״̬ѹ��
    public int maxSubArrays(int[] nums) {
        int n = nums.length;
        int dp_1 = nums[0], dp_2;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp_2 = Math.max(nums[i], dp_1 + nums[i]);
            dp_1 = dp_2;
            max = Math.max(dp_2, max);
        }
        return max;
    }
}
