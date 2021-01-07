package xiaohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 9:06
 *
 * 参考 《labuladong的算法小抄》P405
 */
public class UnionFind {
    // 连通分量
    private int count;
    // 存储每个节点的父节点
    private int[] parent;
    // 记录每棵树的“重量”
    private int[] size;

    /**
     * 初始化构造函数
     * @param n
     */
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始各节点指向本身
            parent[i] = i;
            // 初始各节点树高为1（因为只有一个节点呀，高度为1）
            size[i] = 1;
        }
    }

    /**
     * 合并两个连通分量
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // 小树接到大树下面，较平衡
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
     * 判断两个节点是否已连通
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
     * 找到节点所在的父节点，并返回该节点的父节点
     * @param x
     * @return
     */
    private int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 返回连通分量
     * @return
     */
    public int getCount() {
        return count;
    }
}
