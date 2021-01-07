package xiaohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/7 9:17
 *
 * 547. ʡ������
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // ��������ڵ㣬�ж����ڵ�֮���Ƿ���ͨ
                if (isConnected[i][j] == 1)
                    uf.union(i,j);
            }
        }

        // ������ͨ����  ��Ϊ��Ŀ���� ʡ������
        return uf.getCount();
    }
}
