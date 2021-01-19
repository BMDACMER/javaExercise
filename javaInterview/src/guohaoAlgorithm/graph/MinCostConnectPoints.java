package guohaoAlgorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/19 8:47
 */
public class MinCostConnectPoints {
    // Kruskal 算法
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new Edge(dist(points, i, j), i, j));
            }
        }
        // 从小到大排序
        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });

        // 合并
        int cost = 1, ans = 0;
        for (Edge edge : list) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (uf.union(x, y)) {
                ans += len;
                cost++;
                if (cost == n) break;
            }
        }
        return ans;
    }

    private int dist(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }


}

class Edge {
    int len, x, y;

    public Edge(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
}

class UnionFind{
    int[] parent;
    int[] size;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        this.count = n;

        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return false;

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = parent[rootQ];
            size[rootQ] += size[rootP];
        }
        count--;
        return true;
    }

}