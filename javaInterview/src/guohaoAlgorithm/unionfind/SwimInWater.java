package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/30 9:04
 *
 * 778. 水位上升的泳池中游泳
 * 提示：
 * 2 <= N <= 50.
 * grid[i][j] 是 [0, ..., N*N - 1] 的排列。
 */
public class SwimInWater {


    private int N;
    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        this.N = grid.length;
        int len = N * N;
        // 将二维坐标与一维坐标对应起来
        int[] index = new int[len];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = getIndex(i, j);
            }
        }

        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            int x = index[i] / N;
            int y = index[i] % N;
            for (int[] direction :directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (isArea(newX, newY) && grid[newX][newY] <= i) {
                    uf.union(index[i], getIndex(newX, newY));
                }
            }

            if (uf.isConnect(0, len - 1)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private int getIndex(int x, int y) {
        return x * N + y;
    }
}
