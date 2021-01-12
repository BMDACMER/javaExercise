package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/12 17:19
 * <p>
 * 959. 由斜杠划分区域
 */
public class RegionsBySlashes {

    public int regionsBySlashes(String[] grid) {
        int row = grid.length + 1;
        int col = grid[0].length() + 1;
        UnionFind unionFind = new UnionFind(row * col);

        // 先将举行的外圈各节点连接起来（顺时针方向）
        // 初始化首列和末列
        for (int i = 0; i < row - 1; i++) {
            unionFind.union(i * col, (i + 1) * col);
            unionFind.union(i * col + (col - 1), (i + 1) * col + (col - 1));
        }
        // 初始化 首行和末行
        for (int i = 0; i < col - 1; i++) {
            unionFind.union(i, i + 1);
            unionFind.union(i + (row - 1) * col, i + 1 + (row - 1) * col);
        }

        // 每遇到一条边，更新根节点，判断是否成环
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (grid[i].charAt(j) == '/') {
                    unionFind.union(i * col + j + 1, (i + 1) * col + j);
                } else if (grid[i].charAt(j) == '\\') {
                    unionFind.union(i * col + j, (i + 1) * col + j + 1);
                }
            }
        }

        return unionFind.getCount();
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            if (parent[p] != p && parent[q] != q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }

                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = parent[rootP];
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = parent[rootQ];
                    size[rootQ] += size[rootP];
                }

                count--;
            } else if (parent[p] != p) {
                parent[q] = p;
                size[p] += size[q];
            } else if (parent[q] != q) {
                parent[p] = q;
                size[q] += size[p];
            } else {
                parent[q] = p;
                size[p] += size[q];
            }


        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getCount() {
            return count;
        }
    }
}
