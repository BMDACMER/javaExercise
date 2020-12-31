package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/31 9:38
 *
 * 435. 无重叠区间
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;

        // 按照子数组第二个元素的大小升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return first[1] - second[1];
            }
        });

        int count = 1;   // 不重叠的区间个数
        int firstEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (firstEnd <= intervals[i][0]) {
                count++;
                firstEnd = intervals[i][1];
            }
        }


        return intervals.length - count;   // 需要移除的区间个数
    }

    public static void main(String[] args) {
        EraseOverlapIntervals e = new EraseOverlapIntervals();
        int[][] nums = {{1,2},{2,3}};
        System.out.println(e.eraseOverlapIntervals(nums));
    }
}
