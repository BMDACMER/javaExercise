package 查找表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/25 13:38
 *
 * 349  两个数组的交集
 * 难度：简单
 *
 *   采用set即可
 */
public class 两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer num : nums1) {
            set1.add(num);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (Integer num : nums2) {
            set2.add(num);
        }

        return set1.size() < set2.size() ? help(set1, set2) : help(set2, set1);
    }

    private int[] help(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] output = new int[set1.size()];
        int index = 0;
        for (Integer s : set1){
            if (set2.contains(s))
                output[index++]  = s;
        }
        return Arrays.copyOf(output, index);
    }


}
