package xiaohaoAlgorithm.array;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/3 21:21
 *
 * reference: https://www.geekxh.com/1.0.%E6%95%B0%E7%BB%84%E7%B3%BB%E5%88%97/001.html#_01%E3%80%81%E9%A2%98%E7%9B%AE%E5%88%86%E6%9E%90
 * 第350题：两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Intersection_HashMap {

    /**
     * 统计每个数组元素出现的次数，然后比较两者元素，把相同的元素（次数最少的）存放到res中
     * @param num1
     * @param num2
     */
    public static int[] intersect(int[] num1, int[] num2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashMap<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < num1.length; i++) {
            map1.put(num1[i], map1.getOrDefault(num1[i], 0) + 1);
        }
        for (int i = 0; i < num2.length; i++) {
            map2.put(num2[i], map2.getOrDefault(num2[i], 0) + 1);
        }

        int n = 0;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()){
            if (map1.keySet().contains(entry.getKey())) {
                res.put(entry.getKey(), Math.min(entry.getValue(), map1.get(entry.getKey())));
                n += Math.min(entry.getValue(), map1.get(entry.getKey()));
            }
        }

        int[] out = new int[n];
        int index = 0;

        // 输出结果
        for (Map.Entry<Integer, Integer> map : res.entrySet()) {
            for (int i = 0; i < map.getValue(); i++) {
//                System.out.print(map.getKey() + " ");
                out[index++] = map.getKey();
            }
        }
        return out;
    }

    public static void main(String[] args) {
        /*int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};*/

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
//        intersect(nums1, nums2);
       /* int[] num2 = intersect(nums1, nums2);
        for (Integer num : num2) {
            System.out.print(num + " ");
        }*/

       // 第二种方法
        Intersection_Efficient intersection_efficient = new Intersection_Efficient();
        int[] intersect = intersection_efficient.intersect(nums1, nums2);
        for (Integer num : intersect) {
            System.out.print(num + " ");
        }
    }

}
