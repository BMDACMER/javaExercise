package 深度优先广度优先;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 8:40
 * 130 被围绕的区域
 * 方法一：DFS
 * 思路：可以将矩阵中的o点分为两类，一类是被x围绕的，一类是o在边界或者与边界o相连的
 * 第一步，标记：从左上角边界开始遍历，将第二类o标记为#，第一类o保持不了，这样一次遍历完成后，矩阵中元素为X， O， #
 * 第二步，转换：将标记为o的改为X，再将标记为#的改为o即可
 */
public class 被围绕的区域 {

    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};  // 左上右下
    int m;
    int n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;  // 行
        n = board[0].length;  // 列
        // 1 标记
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j ==0 || j == n - 1) && board[i][j] == 'O')
                    dfs(i, j, board);
            }
        }

        // 2 转换
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
//        m = board.length;
//        n = board[0].length;
        // 边界上为X的
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] != 'O')
            return;

        board[i][j] = '#';
        // 深度优先遍历
        for (int[] direct : directions){
            dfs(i + direct[0], j + direct[1], board);
        }
    }
}
