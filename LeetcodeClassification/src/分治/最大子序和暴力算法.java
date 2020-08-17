package 分治;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 22:40
 * 53 最大子序和
 */
public class 最大子序和暴力算法 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;   // 每次遍历寻找最大子序和
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;  // 用来保存子序列的和
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        最大子序和暴力算法 aa = new 最大子序和暴力算法();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(aa.maxSubArray(nums));
    }
}
