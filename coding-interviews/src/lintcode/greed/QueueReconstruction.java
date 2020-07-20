package lintcode.greed;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/20 13:16
 * 406. 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/
 * (h,k)
 * 思想：
 *      1） 根据h降序，k升序
 *      2）排好序的 根据k的大小插入   ----  调用list的add函数
 */
public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        // 1）根据h降序，k升序
        Arrays.sort(people, ((o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[1] - o1[1])));
        // 2）排好序的 根据k的大小插入
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[list.size()][2]);  // 转为数组
    }
}
