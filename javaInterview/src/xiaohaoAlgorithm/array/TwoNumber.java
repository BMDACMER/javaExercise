package xiaohaoAlgorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/6 14:18
 * 1. 两数之和
 */
public class TwoNumber {
    /*public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }*/

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ans = twoSum(nums, 6);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    /**
     * 以下针对的是有序的
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] {left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

}
