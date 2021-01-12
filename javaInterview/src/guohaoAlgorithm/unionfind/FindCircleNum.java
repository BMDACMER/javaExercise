package guohaoAlgorithm.unionfind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/12 10:36
 *
 * 547. 省份数量
 */
public class FindCircleNum {

    /**
     * 方法一：并查集
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i,j);
                }
            }
        }

        return unionFind.getCount();
    }


    /**
     * 方法二： dfs
     */
    public int findCircleNum2(int[][] isConnected) {
        int count = 0;
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];  // 标记每个节点是否访问
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        int provinces = isConnected.length;
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }

    /**
     * 方法三： bfs
     */
    public int findCircleNum3(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                q.add(i);
                while (!q.isEmpty()) {
                    int j = q.poll();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            q.offer(k);
                        }
                    }
                }
                count++;
            }
        }

        return count;
    }
}

