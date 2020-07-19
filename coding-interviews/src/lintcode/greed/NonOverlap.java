package lintcode.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/19 14:49
 *
 * ���ص����������
 * ˼�룺 ���ܵ�������-�ص���=���ص���   ��������ĩ�˽�����������ĩ��ԽС���������������Խ�󣬲��ص��ĸ���Խ��
 * ÿ�αȽ���һ���������ʼ����ĩ�˵Ĵ�С�����start < end ���ص�  �����ص���+1  ������ܵ�������-���ص��ļ���
 */
public class NonOverlap {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 1) return 0;

        // ��������ĩ�˽�������
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;   // ͳ�Ʋ��ص�����
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end)
                continue;
            end = intervals[i][1];
            count++;
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        NonOverlap nonOverlap = new NonOverlap();
        int[][] arr = new int[][]{{1,100},{11,22},{1,11},{2,12}};
        System.out.println(nonOverlap.eraseOverlapIntervals(arr));
    }
}
