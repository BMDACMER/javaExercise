package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/12 14:17
 *
 * 684. 冗余连接
 */
public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n + 1);
        for (int i = 0; i < n; i++) {
            unionFind.union(edges[i][0], edges[i][1]);
        }

        return unionFind.res;
    }

    private class UnionFind {
        int[] parents;
        // 子树个数 便于后期的路径压缩
        int[] size;
        // 返回需要删除的结果
        int[] res;

        public UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            res = new int[2];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                res[0] = p;
                res[1] = q;
                return;
            }

            if (size[rootP] > size[rootQ]) {
                parents[rootQ] = parents[rootP];
                size[rootP] += size[rootQ];
            } else {
                parents[rootP] = parents[rootQ];
                size[rootQ] += size[rootP];
            }
        }

        public int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
}


