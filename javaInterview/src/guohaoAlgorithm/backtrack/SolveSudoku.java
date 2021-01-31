package guohaoAlgorithm.backtrack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/30 17:40
 *
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
       helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        // 如果遍历到最右端，就开始遍历下一行
        if (j == n) {
            return helper(board, i + 1, 0);
        }
        // 如果遍历到最后一行，表示结束  base case
        if (i == m) {
            return true;
        }
        // 如果该位置是预设的数字，不用管
        if (board[i][j] != '.') {
            return helper(board, i, j + 1);
        }

        for(char ch = '1'; ch <= '9'; ++ch) {
            // 如果遇到不合法数字  跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            // 做选择
            board[i][j] = ch;
            // 开始穷举下一个
            if (helper(board, i, j + 1)) return true;
            // 撤销上一操作
            board[i][j] = '.';
        }
        // 穷举完1-9，依然没有找到可行解，需要前面的格子换个数字穷举
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == ch) return false;
            // 判断列是否重复
            if (board[i][c] == ch) return false;
            // 判断是否在三个小格子中
            if (board[(r/3)*3 + i / 3][(c/3)*3 + i % 3] == ch) return false;
        }
        return true;
    }
}
