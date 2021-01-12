package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/12 16:03
 *
 * 1319. ��ͨ����Ĳ�������
 */
public class MakeConnected {

    /**
     * ˼·�����鼯
     * ���ʣ��ı���>=��ͨ��-1  �򷵻ؿ������ӳɹ���������ͨ��-1
     * ���򷵻� -1  �����������㡣
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] in : connections) {
            unionFind.union(in[0],in[1]);
        }

        int need = unionFind.getCount() - 1;
        int req = unionFind.getRequire();
        return req >= need ? need : -1;
    }

    private class UnionFind{
        int[] parents;
        int[] size;
        int count;
        int require;

        public UnionFind(int n) {
            parents = new int[n];
            size = new int[n];
            count = n;
            require = 0;

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                require++;
                return;
            }

            if (size[rootP] > size[rootQ]) {
                parents[rootQ] = parents[rootP];
                size[rootP] += size[rootQ];
            } else {
                parents[rootP] = parents[rootQ];
                size[rootQ] += size[rootP];
            }

            count--;
        }

        public int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public int getCount() {
            return count;
        }

        public int getRequire() {
            return require;
        }
    }
}
