package xiaohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/11 9:48
 *
 * 300. �����������
 */
public class LengthOfLIS {

    /**
     * ��̬�滮
     * dp[i] ---- �����ַ����н���ÿ���ַ�����λ�õ�������������г���
     * �����ַ�����Ϊ���������У���˳�ʼ��Ϊ1
     * ʱ�临�Ӷ�ΪO(n*n)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // ״̬ת�Ʒ���
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    /**
     * ����������������  ʱ�临�Ӷ�ΪO(nlogn)
     *
     */
    public int lenghtOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // ������ʼ��Ϊ0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // Ҫ���������
            int poker = nums[i];

            /*�������߽�Ķ�������*/
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] < poker) {
                    left = mid + 1;
                } else if (top[mid] > poker) {
                    right = mid;
                } else {
                    right = mid;
                }
            }

            // û���ҵ����ʵ��ƶѣ��½�һ��
            if (left == piles) piles++;
            // �������Ʒŵ��ƶѶ�
            top[left] = poker;
        }
        // �ƶ�������LIS�ĳ���
        return piles;
    }
}
