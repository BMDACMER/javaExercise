package xiaohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 9:06
 *
 * �ο� ��labuladong���㷨С����P405
 */
public class UnionFind {
    // ��ͨ����
    private int count;
    // �洢ÿ���ڵ�ĸ��ڵ�
    private int[] parent;
    // ��¼ÿ�����ġ�������
    private int[] size;

    /**
     * ��ʼ�����캯��
     * @param n
     */
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // ��ʼ���ڵ�ָ����
            parent[i] = i;
            // ��ʼ���ڵ�����Ϊ1����Ϊֻ��һ���ڵ�ѽ���߶�Ϊ1��
            size[i] = 1;
        }
    }

    /**
     * �ϲ�������ͨ����
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // С���ӵ��������棬��ƽ��
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * �ж������ڵ��Ƿ�����ͨ
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * �ҵ��ڵ����ڵĸ��ڵ㣬�����ظýڵ�ĸ��ڵ�
     * @param x
     * @return
     */
    private int find(int x) {
        while (parent[x] != x) {
            // ����·��ѹ��
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * ������ͨ����
     * @return
     */
    public int getCount() {
        return count;
    }
}
