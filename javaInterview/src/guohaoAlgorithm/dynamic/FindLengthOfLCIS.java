package guohaoAlgorithm.dynamic;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/24 9:38
 *
 * 674. �������������  easy
 */
public class FindLengthOfLCIS {

    /**
     * ���룺nums = [1,3,5,4,7]
     * �����3
     * ���ͣ���������������� [1,3,5], ����Ϊ3��
     * ���� [1,3,5,7] Ҳ�������������, �������������ģ���Ϊ 5 �� 7 ��ԭ�����ﱻ 4 ������
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int left = 0, right = 0, len = 1;
        while (right < n - 1) {
            if (nums[right] > nums[right + 1]) {
                len = Math.max(len, right - left + 1);
                left = right + 1;
            }
            right++;
        }
        // ���һ��Ҳ���Ƚ� [1,3,5,7]
        len = Math.max(len, right - left + 1);
        return len;
    }

    // ��̬�滮 �ⷨ
    /**
     * dp[i]----��nums[i]��β�����������������
     * base case: dp[i] = 1
     * ״̬ת�ƣ� if(nums[i] > nums[i-1]) dp[i] = dp[i-1] + 1;
     * return dp[i]������
     */
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp  =new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1])
                dp[i] = dp[i-1] + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
