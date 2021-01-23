package guohaoAlgorithm.graph;

import java.util.*;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 17:11
 *
 *  743. �����ӳ�ʱ��
 *  �ο���https://leetcode-cn.com/problems/network-delay-time/solution/java-ban-dijkstra-spfa-floydxiang-xi-ti-jie-by-jer/
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        // ��ʼ���ڽӱ�
        for (int[] t : times) {
            map.computeIfAbsent(t[0], k -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }

        // ��ʼ��dis�����vis����
        int[] dis = new int[N + 1];
        Arrays.fill(dis, 0x3f3f3f3f);
        boolean[] vis = new boolean[N + 1];

        // ����disΪ0�����Ǳ�����0ҲҪ��һ�£���Ϊ���ǲ�����ģ��Ҽ�������ʱ��ֱ������stream���������0Ҳ��Ҫ��ʼ������
        dis[K] = 0;
        dis[0] = 0;

        // newһ��С�ѳ���������dis�����ţ�һ��Ҫ������С�����ţ�ʡȥ���ɳڹ���
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> dis[o1] - dis[o2]);
        // �����Ž�ȥ
        queue.offer(K);

        while (!queue.isEmpty()) {
            // �����в��գ��ó�һ��Դ����
            Integer poll = queue.poll();
            if(vis[poll]) continue;
            // �������Ϊ���ʹ�
            vis[poll] = true;
            // ���������ھ��ǣ���Ȼ����û�ھӣ�������getOrDefault����ͺܷ���
            List<int[]> list = map.getOrDefault(poll, Collections.emptyList());
            for (int[] arr : list) {
                int next = arr[0];
                // �������ھӷ��ʹ��ˣ�����
                if (vis[next]) continue;
                // ���µ�����ھӵ���̾��룬�����ǲ��ǵ�ǰpoll�����Ľڵ㵽������һ��
                dis[next] = Math.min(dis[next], dis[poll] + arr[1]);
                queue.offer(next);
            }
        }
        // �õ������е����ֵ�Ƚ��£����ؽ��
        int res = Arrays.stream(dis).max().getAsInt();
        return res == 0x3f3f3f3f ? -1 : res;
    }

}
