package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 15:37
 * P396-405
 *
 */
public class UnionFind {
    int[] parent;
    int count;
    int[] size;   // ÿ������������

    public UnionFind(int n) {
        parent = new int[n];
        this.count = n;
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // ���ÿ������ֻ��һ���ڵ㣬���ڵ�ָ���Լ�
            parent[i] = i;
            // ���ÿ��������һ���ڵ㣬��ʼ��Ϊ1
            size[i] = 1;
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = parent[rootP];
            size[p] += size[q];
        } else {
            parent[rootP] = parent[rootQ];
            size[q] += size[p];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int count() {
        return count;
    }
}
