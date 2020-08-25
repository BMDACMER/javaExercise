package ���ұ�;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/25 21:15
 * 350. ��������Ľ��� II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class ��������Ľ���2 {

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
     * �ⷨ�� �� ����hashmapͳ��
     *
     * ����ͬһ�����������������ж����ܳ��ֶ�Σ������Ҫ�ù�ϣ��洢ÿ�����ֳ��ֵĴ���������һ�����֣����ڽ����г��ֵĴ������ڸ����������������г��ִ�������Сֵ��
     *
     * ���ȱ�����һ�����飬���ڹ�ϣ���м�¼��һ�������е�ÿ�������Լ���Ӧ���ֵĴ�����Ȼ������ڶ������飬���ڵڶ��������е�ÿ�����֣�����ڹ�ϣ���д���������֣��򽫸�������ӵ��𰸣������ٹ�ϣ���и����ֳ��ֵĴ�����
     *
     * Ϊ�˽��Ϳռ临�Ӷȣ����ȱ����϶̵����鲢�ڹ�ϣ���м�¼ÿ�������Լ���Ӧ���ֵĴ�����Ȼ������ϳ�������õ�������
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     *
     * ʱ�临�Ӷȣ�O(m+n)O(m+n)
     * �ռ临�Ӷȣ�O(\min(m,n))O(min(m,n))
     */

    public int[] intersect2(int[] nums1, int[] nums2) {
        // ��֤ nums1�ĳ���ʼ����С
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
