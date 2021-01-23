package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 11:03
 *
 * 300. �����������
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * ���룺nums = [10,9,2,5,3,7,101,18]
 * �����4
 * ���ͣ�������������� [2,3,7,101]����˳���Ϊ 4 ��
 */
public class LengthOfLIS {

    // ��̬�滮
    public int lengthOfLIS(int[] nums) {
        /**
         * dp[i] --- �������±�i��λ��֮ǰ���������������
         * ÿ��������ȫ����ʼ��Ϊ1
         * ���� j ��[0,i)��ֻҪ�ҵ���nums[i]С��Ԫ�أ�Ȼ��nums[i]�ӵ����漴�ɡ����ȼ�һ��
         *              dp[i] = max(dp[i], dp[j] + 1);
         *  ��󣬱�������dp���飬�ҳ���󼴿�
         */
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //  �������� ��������  �ο�P102-103
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int piles = 0;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = nums[i];

            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } if (top[mid] < poker) {
                    left = mid + 1;
                } else if (top[mid] == poker) {
                    right = mid;
                }
            }
            // û�ҵ����ʵ��ƶѣ��½�һ��
            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }


    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(l.lengthOfLIS2(nums));
    }
}
