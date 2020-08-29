package 对撞指针;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 19:00
 * 447 回旋镖的数量
 * https://leetcode-cn.com/problems/number-of-boomerangs/solution/javashi-jian-fu-za-du-on2shi-yong-map-by-victor94/
 *
 * 思路：
 */
public class 回旋镖的数量 {
    public int numberOfBoomerangs(int[][] points) {
        //思路： 计算某个点与剩余其他点的距离，用hashmap存放，key为 两点之间的距离，value为此距离的次数，也就是有几条，
        // 这样就可以通过hashmap中的value值找到满足题意的点的对数啦
        // 最后在外层套一层循环即可
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    map.put(distance(points[i], points[j]), map.getOrDefault(distance(points[i], points[j]),0) + 1);
                }
            }

            for (int k : map.values()) {
                if (k >= 2)
                    res += k*(k-1);   // 排列组合
            }
        }

        return res;
    }

    private int distance(int[] x, int[] y) {
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }

    public static void main(String[] args) {
        回旋镖的数量 m = new 回旋镖的数量();
        int[][] nums = {{0,0},{1,0},{2,0}};
        System.out.println(m.numberOfBoomerangs(nums));
    }
}
