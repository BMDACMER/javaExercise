package lintcode.greed;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/20 13:16
 * 406. ��������ؽ�����
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/
 * (h,k)
 * ˼�룺
 *      1�� ����h����k����
 *      2���ź���� ����k�Ĵ�С����   ----  ����list��add����
 */
public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        // 1������h����k����
        Arrays.sort(people, ((o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[1] - o1[1])));
        // 2���ź���� ����k�Ĵ�С����
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[list.size()][2]);  // תΪ����
    }
}
