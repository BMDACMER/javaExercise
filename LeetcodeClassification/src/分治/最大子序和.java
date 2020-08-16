package ����;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 ��������
 */
public class �������� {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }

    public static void main(String[] args) {
        �������� aa = new ��������();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
