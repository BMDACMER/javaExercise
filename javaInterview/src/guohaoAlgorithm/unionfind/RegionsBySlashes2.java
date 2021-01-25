package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/12 23:07
 *
 * 959. 由斜杠划分区域   1.25号的每日一题
 */
public class RegionsBySlashes2 {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // 将一个小正方形划分为 4块区域
        UnionFind uf = new UnionFind(4 * n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 将二维坐标转为一维
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

                // 同一列，上下两个相等的小正方形的坐标为 (i,j)   (i-1,j)
                // 将上一个小正方形的第三个区域与下一个小正方形的第一个区域连通
                if (i > 0) uf.union(start, start - 4 * n + 2);
                // 同一行，左右两个相等的小正方形的坐标为(i,j)  (i,j-1)
                // 将左边的小正方形的第二个区域与当前小正方形的第三个区域连通
                if (j > 0) uf.union(start + 3, start - 3);
            }
        }
        return uf.getCount();
    }

}
