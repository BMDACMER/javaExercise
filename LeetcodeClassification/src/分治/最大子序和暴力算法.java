package ����;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 ��������
 */
public class �������ͱ����㷨 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;   // ÿ�α���Ѱ����������
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;  // �������������еĺ�
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        �������ͱ����㷨 aa = new �������ͱ����㷨();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
