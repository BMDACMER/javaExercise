package lintcode.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/19 15:13
 *
 * 452. 用最少数量的箭引爆气球
 *
 */
public class ArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {

        if (points.length < 1) return 0;

        // 按照区间末端进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;   // 统计不重叠区间
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end)
                continue;
            end = points[i][1];
            count++;
        }

        return count;
    }

}
