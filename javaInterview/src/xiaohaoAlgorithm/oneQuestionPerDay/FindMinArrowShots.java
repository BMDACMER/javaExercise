package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/31 9:57
 *
 * 452. 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {

    /**
     * 思路：与435 EraseOverlapIntervals相似  贪心算法
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n < 2) return n;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int count = 1; // 初始化 该区间未与任何区间重叠 需要一次引爆机会
        int firstEnd = points[0][1];
        for (int i = 1; i < n; i++) {
            if (firstEnd < points[i][0]) {
                count++;
                firstEnd = points[i][1];
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
