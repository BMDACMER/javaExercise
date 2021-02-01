package guohaoAlgorithm.greedy;

import javabase.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 10:54
 *
 * 452. �����������ļ���������
 * �ڶ�ά�ռ�����������ε����򡣶���ÿ�������ṩ��������ˮƽ�����ϣ�����ֱ���Ŀ�ʼ�ͽ������ꡣ��������ˮƽ�ģ����������겢����Ҫ�����ֻҪ֪����ʼ�ͽ����ĺ�������㹻�ˡ���ʼ��������С�ڽ������ꡣ
 *
 * һ֧������������ x ��Ӳ�ͬ����ȫ��ֱ������������� x �����һ֧��������һ�������ֱ���Ŀ�ʼ�ͽ�������Ϊ xstart��xend�� ������  xstart �� x �� xend���������ᱻ��������������Ĺ���������û�����ơ� ����һ�������֮�󣬿������޵�ǰ�����������ҵ�ʹ����������ȫ��������������Ĺ�������С������
 *
 * ����һ������ points ������ points [i] = [xstart,xend] �������������������������������С��������
 *
 *
 * ʾ�� 1��
 *
 * ���룺points = [[10,16],[2,8],[1,6],[7,12]]
 * �����2
 * ���ͣ����ڸ�������x = 6 �����䱬 [2,8],[1,6] ���������Լ� x = 11 �䱬������������
 */
public class FindMinArrowShots {

    // ��ʵ�������ཻ����   ע������һ��435���������� ����ȵĴ���
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n < 2) return n;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int end = points[0][1], count = 1;
        for (int[] p : points) {
            if (p[0] > end) {
                count++;
                end = p[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindMinArrowShots f = new FindMinArrowShots();
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(f.findMinArrowShots(points));
    }
}
