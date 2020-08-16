package 分治;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/16 21:10
 * 169 多数元素
 */
public class 多数元素 {

    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer,Integer> entry : entries) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {3,3,3,2,1};
        System.out.println(多数元素.majorityElement(nums));;
    }
}
