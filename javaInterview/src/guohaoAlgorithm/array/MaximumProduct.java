package guohaoAlgorithm.array;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/20 9:19
 */
public class MaximumProduct {

    // 三个数要么是最大的三个数  要么是两个最小的 和一个最大的
    // 时间复杂度为O(nlogn)
    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        return Math.max(nums[n]*nums[n-1]*nums[n-2], nums[0]*nums[1]*nums[n]);
    }

    // 方法二   时间复杂度为 O(n)
    public int maximumProduct(int[] nums) {
        // min1 最小   min2 第二小
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // max1第1大   max2第二大  max3 第三大
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            }else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            }else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }

    public static void main(String[] args) {
        MaximumProduct m = new MaximumProduct();
        int[] nums = {-1,-2,-3};
        System.out.println(m.maximumProduct(nums));
    }
}
