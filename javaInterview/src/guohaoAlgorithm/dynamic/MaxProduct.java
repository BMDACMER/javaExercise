package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/25 20:29
 *
 * 152. �˻����������
 * ����һ���������� nums �������ҳ������г˻��������������飨�������������ٰ���һ�����֣���
 * �����ظ�����������Ӧ�ĳ˻���
 *
 * ʾ�� 1:
 *
 * ����: [2,3,-2,4]
 * ���: 6
 * ����: ������ [2,3] �����˻� 6��
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        // dp[i]----��nums[i]Ϊ����������������˻�
        /**
         * dp[0] --- [2]     2
         * dp[1] --- [2,3]  2*3=6
         * dp[2] --- [-2]  -2
         * dp[3] --- [4]  4
         *
         * ���ͳ��dp�����ļ���
         * base case: dp[i] = nums[i];
         * dp[i] = max(dp[i], dp[i-1] * nums[i]);
         *
         * ��Ϊ�����Ĵ��� ����Ĳ�����
         */
        int n = nums.length;
        int maxValue = 1, minValue = 1, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                int temp = maxValue;
                maxValue = minValue;
                minValue = temp;
            }
            maxValue = Math.max(maxValue * nums[i], nums[i]);
            minValue = Math.min(minValue * nums[i], nums[i]);

            max = Math.max(maxValue, max);
        }

        return max;
    }
}
