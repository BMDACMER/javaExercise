package 对撞指针;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/26 11:25
 *
 * 1、 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
     return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey((target - nums[i]))) {
                return new int[] {map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        两数之和 m = new 两数之和();
        int[] num = {2,8,7,0,1};
        int target = 9;
        int[] temp = m.twoSum2(num, target);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + "\t");
        }
        System.out.println();
    }
}
