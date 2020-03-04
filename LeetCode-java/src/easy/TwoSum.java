package easy;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	// 暴力算法  （效率低）
	public int[] twoSum(int[] nums, int target) {
		int[] a = new int[2];   // 记录两个下标
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					a[0] = i;
					a[1] = j;
					return a;
				}
			}
		}
		return a;
	}
	
	// HashMap方法 
	public int[] twoSum2(int[] nums, int target) {
		int[] b = new int[2];
		HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			hashmap.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if(hashmap.containsKey(target - nums[i]) && i != (target - nums[i])) {
				b[0] = i;
				b[1] = hashmap.get((target - nums[i]));
				return b;
			}
		}
		return b;
	}
	
	// HashMap  一次循环
	public int[] twoSum3(int[] nums, int target) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey((target - nums[i]))) {
				return new int[] {map.get(nums[i]),i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
}
