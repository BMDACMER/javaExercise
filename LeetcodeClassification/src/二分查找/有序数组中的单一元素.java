package 二分查找;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/30 17:21
 * 540 有序数组中的单一元素
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 *
 *
 */
public class 有序数组中的单一元素 {
    /**
     * 采用散列表   key--元素，value-出现次数
     * 找出value为1的返回key即可   ----  复杂度为 O(n) s
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;  // 题目中假设一定存在  所以此处不会执行
    }

    /**
     * 因为是有序数组，所以可以用二分法。思路：取数组中间的数，当中间数的下标为奇数，说明前后元素的个数为奇数，
     * 偶数则剩余个数为偶数。奇数时：当nums[h]等于[h+1],唯一数处于前h-1,反之处于后h+1。
     * 偶数时：当nums[h]等于[h+1]，唯一数处于后h+2,反之处于前h.(就是要保证剩余查找元素个数奇数)
     *
     * 作者：qiu-offer-3
     * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/java-er-fen-fa-0msji-bai-liao-10000-by-qiu-offer-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            if ((middle&1)== 1) { // 下标为奇数
                if (nums[middle] == nums[middle+1]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {   // 下标为偶数
                if (nums[middle] == nums[middle+1]) {
                    left = middle + 2;
                } else {
                    right = middle - 1;
                }
            }

        }
        return nums[left];
    }

}
