package xiaohaoAlgorithm.backtrack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/25 11:45
 *
 * 37. 解数独
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列，转为下一行
            return backtrack(board, i+1, 0);
        }
        if (i == m) {
            // 找到一个可行解，触发 base case
            return true;
        }

        if (board[i][j] != '.') {
            // r如果没有预设数字，不用我们穷举
            return backtrack(board, i, j+1);
        }

        for (char ch = '1'; ch < '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch))
                continue;
            board[i][j] = ch;
            // 如果找到一个可行解，理解结束
            if(backtrack(board, i, j + 1))
                return true;
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // 判断是否重复
            if (board[r][i] == ch) return false;
            if (board[i][c] == ch) return false;
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == ch)
                return false;
        }
        return true;
    }
}
