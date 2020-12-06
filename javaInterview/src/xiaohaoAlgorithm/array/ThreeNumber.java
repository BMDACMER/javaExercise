package xiaohaoAlgorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/6 14:46
 * 15. 三数之和
 */
public class ThreeNumber {
    /**
     * 思想：固定一个值，搭配双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        int n = nums.length;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = n - 1;
            if (nums[i] > 0) {
                break;
            }

            if (i == 0 || nums[i] != nums[i - 1]) {
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] == 0) {
                        lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])  left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[i] > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

        }
        return lists;
    }
}
