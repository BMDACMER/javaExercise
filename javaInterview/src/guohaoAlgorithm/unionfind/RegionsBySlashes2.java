package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/12 23:07
 *
 * 959. ��б�ܻ�������   1.25�ŵ�ÿ��һ��
 */
public class RegionsBySlashes2 {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // ��һ��С�����λ���Ϊ 4������
        UnionFind uf = new UnionFind(4 * n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // ����ά����תΪһά
                int start = 4 * (i * n  +j);
                switch (grid[i].charAt(j)) {
                    case ' ':
                        uf.union(start + 0,start+1);
                        uf.union(start + 1, start + 2);
                        uf.union(start + 3, start + 0);
                        break;
                    case '/':
                        uf.union(start + 0, start + 3);
                        uf.union(start + 1, start + 2);
                        break;
                    case '\\':
                        uf.union(start+0,start+1);
                        uf.union(start + 2, start + 3);
                        break;
                }

                // ͬһ�У�����������ȵ�С�����ε�����Ϊ (i,j)   (i-1,j)
                // ����һ��С�����εĵ�������������һ��С�����εĵ�һ��������ͨ
                if (i > 0) uf.union(start, start - 4 * n + 2);
                // ͬһ�У�����������ȵ�С�����ε�����Ϊ(i,j)  (i,j-1)
                // ����ߵ�С�����εĵڶ��������뵱ǰС�����εĵ�����������ͨ
                if (j > 0) uf.union(start + 3, start - 3);
            }
        }
        return uf.getCount();
    }

}
