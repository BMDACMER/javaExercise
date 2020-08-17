package ����;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 ��������
 */
public class �������Ͷ�̬�滮 {
    /*public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // ��ʼ��
        for (int i = 1; i < nums.length; i++) {
            // ״̬ת�Ʒ���
            if (dp[i-1] >= 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // dp�����м�¼�����е������еĺͣ��ҳ����ļ���
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/
    // ��һ���Ż�
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        �������Ͷ�̬�滮 aa = new �������Ͷ�̬�滮();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
