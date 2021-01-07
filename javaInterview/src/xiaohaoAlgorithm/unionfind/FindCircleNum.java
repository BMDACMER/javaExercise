package xiaohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 9:17
 *
 * 547. 省份数量
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历如果节点，判断两节点之间是否连通
                if (isConnected[i][j] == 1)
                    uf.union(i,j);
            }
        }

        // 返回连通分量  即为题目所求 省份数量
        return uf.getCount();
    }
}
