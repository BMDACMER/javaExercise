package lintcode.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/19 14:49
 *
 * 不重叠的区间个数
 * 思想： 用总的区间数-重叠的=不重叠的   按照区间末端进行排序，这样末端越小，留给后面的区间越大，不重叠的概率越大
 * 每次比较下一个区间的起始端与末端的大小，如果start < end 则重叠  否则不重叠数+1  最后用总的区间数-不重叠的即可
 */
public class NonOverlap {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 1) return 0;

        // 按照区间末端进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;   // 统计不重叠区间
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
