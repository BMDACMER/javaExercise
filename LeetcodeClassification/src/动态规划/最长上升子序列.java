package ��̬�滮;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/21 13:40
 *
 * 300 �����������
 *
 * ���ö�̬�滮��ʽ
 *
 * 1��dp[i] --- �������ǰi��Ԫ�ص���������г���
 * 2������ j �� (0,i)����
 *      if num[i] > num[j]��dp[i] = Math.max(dp[i], dp[j] + 1);
 *      ���� ʲôҲ����
 * 3����ʼ��״̬  dp[i] = 1;  // ��Ϊÿ��Ԫ�ض����������������䳤��Ϊ 1
 */
public class ����������� {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);   // ȷ����̬�滮״̬

        // �ҳ�dp[i]����������Ϊ ��������г���
        int maxL = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }

        return maxL;
    }

    public static void main(String[] args) {
        ����������� m = new �����������();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(m.lengthOfLIS(nums));
    }

    private int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
