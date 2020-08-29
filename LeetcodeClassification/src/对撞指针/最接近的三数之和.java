package 对撞指针;

import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 15:47
 *
 * 16 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * 思路：在三数之和基础上，更改sum = target为 min(sum - target, min)
 */
public class 最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;

        Arrays.sort(nums);

        int sum;
        int best = 10000;  // 千万别写Integer.MAX_VALUE; 不然[-3,-2,-5,3,-4] 通过不了
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int second = i + 1;
            int third = n - 1;

            while (second < third) {
                sum = nums[i] + nums[second] + nums[third];
                if (sum == target) return sum;

                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }


                if (sum > target) {
                    third--;
                    while (second < third && nums[third] == nums[third + 1]) third--;
                }

                if (sum < target){
                    second++;
                    while (second < third && nums[second] == nums[second - 1]) second++;
                }

            }
        }

        return best;
    }

    public static void main(String[] args) {
        最接近的三数之和 m = new 最接近的三数之和();
//        int[] nums ={0,2,1,-3};
//        int[] nums ={-1,2,1,-4};
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(m.threeSumClosest(nums,-1));
    }
}
