package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 17:20
 *
 * 130 被围绕的区域
 */
public class SurroundedArea {

    /**
     * 并查集
     *  参考：P410
     * 先假设一个dummy节点作为根，将最外圈的"O" 与dummy连接，最后遍历剩余的节点，如果没有连通，则将o改为x
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0) return;
        // 因为并查集是一维的 ，所以先要将 board二维数组转为一维的
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;
        // 将第一行和最后一行 中的 O
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                uf.union(i, dummy);
            if (board[m - 1][i] == 'O')
                uf.union(n * (m - 1) + i, dummy);
        }

        // 将第一列和最后一列 中的 O 与dummy连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }

        // 方向数组d是搜索上下左右四个方向的常用手法
        int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    // 将此 O 与上下左右的 O相通
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O')
                            uf.union(x*n+y, i*n+j);

                    }
                }
            }

        }

        // 现在没有呗X包围的 O 都和 dummy相通
        // 所有不和dummy相同的o都要被替换
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connect(dummy, i * n + j))
                    board[i][j] = 'X';
            }
        }
    }

    /**
     * dfs 方法
     */
    public void dfs(char[][] board) {
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        dfs(board, m, n);
        // 把第一行和最后一行关联的O变为#
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        // 把第一列和最后一列 关联的 O变为#
        for (int j = 0; j < m; j++) {
            dfs(board, j, 0);
            dfs(board, j, n - 1);
        }

        // 剩下的O都是应该呗替换掉的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    // 方向数组d是搜索上下左右四个方向的常用手段
    int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        if (board[i][j] != 'O') return;

        // 进行转换
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            dfs(board, i + d[k][0], j + d[k][1]);
        }
    }
}
