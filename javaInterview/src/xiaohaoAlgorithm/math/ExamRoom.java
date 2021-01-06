package xiaohaoAlgorithm.math;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 18:40
 *
 * 855. 考场就座
 *
 * 参考：P389-395
 */
public class ExamRoom {

    // 将端点p 映射到 以端点P为左端点的线段
    private HashMap<Integer,int[]> startMap;
    // 将端点p 映射到 以端点p为右端点的线段
    private HashMap<Integer, int[]> endMap;
    // 用来存储排好序的线段
    TreeSet<int[]> pq;
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a,b) -> {
            // 算出两个线段的长度
            int distA = distance(a);
            int distB = distance(b);
            if (distA == distB)
                return b[0] - a[0];
            return distA - distB;
        });
        // 在有序集合中先放一个虚拟线段
        addInterval(new int[]{-1, N});
    }

    /**
     * 移除线段
     * @param interval
     */
    private void removeInterval(int[] interval) {
        pq.remove(interval);
        startMap.remove(interval[0]);
        endMap.remove(interval[1]);
    }


    /**
     * 添加线段
     * @param interval
     */
    private void addInterval(int[] interval) {
        pq.add(interval);
        startMap.put(interval[0], interval);
        endMap.put(interval[1], interval);
    }

    /**
     * 计算线段中点到两端的距离
     * @param interval
     * @return
     */
    private int distance(int[] interval) {
        int x = interval[0];
        int y = interval[1];
        if (x == -1) return y;
        if (y == N) return N - 1 - x;
        // 中点和端点之间的长度
        return (y - x) / 2;
    }


    public int seat() {
        // 从有序集合中拿出最长的线段
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            // 情况一 最左边没人的话肯定坐最左边
            seat = 0;
        } else if (y == N) {
            // 情况二 最右边没人的话 肯定坐在左右边
            seat = N - 1;
        } else {
            // 情况三  不是边界的话，就坐中间
            seat = x + (y - x )/ 2;
        }

        // 将最长的线段分成两段
        int[] left = new int[] {x, seat};
        int[] right = new int[] {seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        // 将 p 左右的线段找出来
        int[] right = startMap.get(p);
        int [] left = endMap.get(p);
        // 将两条线段合并为一条
        int[] merged = new int[] {left[0], right[1]};
        // 删除就线段，插入新线段
        removeInterval(right);
        removeInterval(left);
        addInterval(merged);
    }
}
