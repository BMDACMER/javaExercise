package 对撞指针;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 17:21
 * 454 四数相加II
 * https://leetcode-cn.com/problems/4sum-ii/
 * <p>
 * 思路：将4组数组分成两组，这样算法时间复杂度为 O(N*N)
 * <p>
 * 1、采用分为两组，HashMap存一组，另一组和HashMap进行比对。
 * 2、HashMap存两个数组之和，如AB。然后计算两个数组之和，如CD。时间复杂度为：O(n^2)+O(n^2),得到O(n^2).
 * 3、我们以存AB两数组之和为例。首先求出A和B任意两数之和sumAB，以sumAB为key，sumAB出现的次数为value，存入hashmap中。
 * 然后计算C和D中任意两数之和的相反数sumCD，在hashmap中查找是否存在key为sumCD。
 */
public class 四数相加II {
    /*public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[i];
                map.put(sumAB, map.getOrDefault(sumAB,0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i] + D[i]);
                if (map.containsKey(sumCD))
                    res += map.get(sumCD);
            }
        }

        return res;
    }*/

    /*public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[j];
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i] + D[i]);
                if (map.containsKey(sumCD))
                    res += map.get(sumCD);
            }
        }

        return res;
    }*/

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int temp = A[i] + B[j];
                map.put(temp, map.getOrDefault(temp,0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int temp = -(C[i] + D[j]);
                if (map.containsKey(temp))
                    sum += map.get(temp);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        四数相加II m = new 四数相加II();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(m.fourSumCount(A, B, C, D));
    }

}
