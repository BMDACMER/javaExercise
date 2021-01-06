package xiaohaoAlgorithm.math;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 18:40
 *
 * 855. ��������
 *
 * �ο���P389-395
 */
public class ExamRoom {

    // ���˵�p ӳ�䵽 �Զ˵�PΪ��˵���߶�
    private HashMap<Integer,int[]> startMap;
    // ���˵�p ӳ�䵽 �Զ˵�pΪ�Ҷ˵���߶�
    private HashMap<Integer, int[]> endMap;
    // �����洢�ź�����߶�
    TreeSet<int[]> pq;
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a,b) -> {
            // ��������߶εĳ���
            int distA = distance(a);
            int distB = distance(b);
            if (distA == distB)
                return b[0] - a[0];
            return distA - distB;
        });
        // �����򼯺����ȷ�һ�������߶�
        addInterval(new int[]{-1, N});
    }

    /**
     * �Ƴ��߶�
     * @param interval
     */
    private void removeInterval(int[] interval) {
        pq.remove(interval);
        startMap.remove(interval[0]);
        endMap.remove(interval[1]);
    }


    /**
     * ����߶�
     * @param interval
     */
    private void addInterval(int[] interval) {
        pq.add(interval);
        startMap.put(interval[0], interval);
        endMap.put(interval[1], interval);
    }

    /**
     * �����߶��е㵽���˵ľ���
     * @param interval
     * @return
     */
    private int distance(int[] interval) {
        int x = interval[0];
        int y = interval[1];
        if (x == -1) return y;
        if (y == N) return N - 1 - x;
        // �е�Ͷ˵�֮��ĳ���
        return (y - x) / 2;
    }


    public int seat() {
        // �����򼯺����ó�����߶�
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            // ���һ �����û�˵Ļ��϶��������
            seat = 0;
        } else if (y == N) {
            // ����� ���ұ�û�˵Ļ� �϶��������ұ�
            seat = N - 1;
        } else {
            // �����  ���Ǳ߽�Ļ��������м�
            seat = x + (y - x )/ 2;
        }

        // ������߶ηֳ�����
        int[] left = new int[] {x, seat};
        int[] right = new int[] {seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        // �� p ���ҵ��߶��ҳ���
        int[] right = startMap.get(p);
        int [] left = endMap.get(p);
        // �������߶κϲ�Ϊһ��
        int[] merged = new int[] {left[0], right[1]};
        // ɾ�����߶Σ��������߶�
        removeInterval(right);
        removeInterval(left);
        addInterval(merged);
    }
}
