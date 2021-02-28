package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 16:53
 *
 * ���鼯 ģ��
 */
public class UnionFind {
    // ��Žڵ�ĸ��ڵ�
    int[] parent;
    // ��ͨ����
    int count;
    // �����нڵ�����
    int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        this.count = n;
        size = new int[n];

        // ��ʼ��
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = parent[rootP];
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = parent[rootQ];
            size[rootQ] += size[rootP];
        }

        count--;
    }

    public boolean connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    // ��һ��д��
    public int findII(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int getCount() {
        return count;
    }

    public boolean isConnect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
}
