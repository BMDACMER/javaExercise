package guohaoAlgorithm.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/12 16:18
 *
 * 1631. 最小体力消耗路径
 */
public class MinimumEffortPath {

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        List<Edge> res = new ArrayList<>();
        // 将二位数组各相邻点之间的差存储在res中
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int idx = i * col + j;
                if (i > 0) res.add(new Edge(idx - col, idx, Math.abs(heights[i][j] - heights[i-1][j])));
                if (j > 0) res.add(new Edge(idx - 1, idx, Math.abs(heights[i][j] - heights[i][j - 1])));
            }
        }

        Collections.sort(res, (a,b) -> a.val - b.val);

        UnionFind unionFind = new UnionFind(row * col);
        for (Edge e : res) {
            unionFind.union(e.node1, e.node2);
            if (unionFind.isConnect(0, row * col - 1)) return e.val;
        }
        return 0;
    }

    class Edge{
        int node1, node2;
        int val;

        public Edge(int node1, int node2, int val) {
            this.node1 = node1;
            this.node2 = node2;
            this.val = val;
        }
    }
}
