package xiaohaoAlgorithm.array;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/3 22:12
 */
public class Intersection_Efficient {

    /**
     *  ���ȱȽ�������������һ�� ͳ�Ƹ�Ԫ�صĸ�����Ȼ�������һ�������Ԫ�ش�ŵ�res����м���
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // ��֤nums1�ĳ���ʼ����С
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // ͳ������nums2��Ԫ�صĸ���
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (Integer num : nums1) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
            /*int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count>0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
           if (map.get(num) > 0) {
               res[index++] = num;
               map.put(num, map.get(num) - 1);
           }*/
        }


        return Arrays.copyOf(res, index);
    }
}
