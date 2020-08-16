package 分治;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 最大子序和
 */
public class 最大子序和 {
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
        最大子序和 aa = new 最大子序和();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
