package ��ײָ��;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/29 19:00
 * 447 �����ڵ�����
 * https://leetcode-cn.com/problems/number-of-boomerangs/solution/javashi-jian-fu-za-du-on2shi-yong-map-by-victor94/
 *
 * ˼·��
 */
public class �����ڵ����� {
    public int numberOfBoomerangs(int[][] points) {
        //˼·�� ����ĳ������ʣ��������ľ��룬��hashmap��ţ�keyΪ ����֮��ľ��룬valueΪ�˾���Ĵ�����Ҳ�����м�����
        // �����Ϳ���ͨ��hashmap�е�valueֵ�ҵ���������ĵ�Ķ�����
        // ����������һ��ѭ������
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
                    res += k*(k-1);   // �������
            }
        }

        return res;
    }

    private int distance(int[] x, int[] y) {
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }

    public static void main(String[] args) {
        �����ڵ����� m = new �����ڵ�����();
        int[][] nums = {{0,0},{1,0},{2,0}};
        System.out.println(m.numberOfBoomerangs(nums));
    }
}
