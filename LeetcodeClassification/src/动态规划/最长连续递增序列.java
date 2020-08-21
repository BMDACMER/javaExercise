package ��̬�滮;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 13:59
 * <p>
 * ��̬�滮
 * dp[i]  ---- ��nums[i]��β�������������г��ȡ�
 * 1����ʼ��״̬  dp[i] = 1 // ÿ��Ԫ���������������
 * 2��״̬ת�Ʒ���
 * for j in [1,i]
 * if nums[j] > nums[j-1], dp[j] += 1;
 * else dp[j] = dp[j-1]
 */
public class ������������� {

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        if (nums.length == 1) return 1;

        int maxL = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;

            maxL = Math.max(maxL, dp[i]);
        }
        return maxL;
    }

    public static void main(String[] args) {
        ������������� m = new �������������();
        int[] nums = {1, 3, 5, 4, 7, 8, 9, 10};
        System.out.println(m.findLengthOfLCIS(nums));
    }
}
