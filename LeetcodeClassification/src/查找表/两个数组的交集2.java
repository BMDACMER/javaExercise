package 查找表;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/25 21:15
 * 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class 两个数组的交集2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        int n = nums1.length < nums2.length ? nums1.length : nums2.length;
        int[] output = new int[n];
        int index = 0;

        for (Map.Entry<Integer, Integer> map : map1.entrySet()) {
            if (map2.containsKey(map.getKey())) {
                int temp = map2.get(map.getKey()) < map.getValue() ? map2.get(map.getKey()) : map.getValue();
                for (int i = 0; i < temp; i++) {
                    output[index++] = map.getKey();
                }
            }
        }

        return Arrays.copyOf(output, index);
    }


    /**
     * 解法二 ： 采用hashmap统计
     *
     * 由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
     *
     * 首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
     *
     * 为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 时间复杂度：O(m+n)O(m+n)
     * 空间复杂度：O(\min(m,n))O(min(m,n))
     */

    public int[] intersect2(int[] nums1, int[] nums2) {
        // 保证 nums1的长度始终最小
        if (nums1.length > nums2.length)
            return intersect2(nums2, nums1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
        
        int n = nums1.length;
        int[] output = new int[n];
        int index = 0;

        for (Integer num : nums1) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                output[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOf(output, index);
    }
}
