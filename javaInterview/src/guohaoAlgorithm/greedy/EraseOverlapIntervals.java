package guohaoAlgorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 10:48
 *
 * 435. ���ص�����
 * ����һ������ļ��ϣ��ҵ���Ҫ�Ƴ��������С������ʹʣ�����以���ص���
 *
 * ע��:
 *
 * ������Ϊ������յ����Ǵ���������㡣
 * ���� [1,2] �� [2,3] �ı߽��໥���Ӵ�������û���໥�ص���
 * ʾ�� 1:
 *
 * ����: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * ���: 1
 *
 * ����: �Ƴ� [1,3] ��ʣ�µ�����û���ص���
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 1 || intervals[0].length < 1) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int len = intervals.length, end = intervals[0][1];
        int count = 1;// ������ɵ�����
        for (int[] arr : intervals) {
            if (arr[0] >= end){
                count++;
                end = arr[1];
            }
        }
        return len - count;  //�ཻ������
    }
}
