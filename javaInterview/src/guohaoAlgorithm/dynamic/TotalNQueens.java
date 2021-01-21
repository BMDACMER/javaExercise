package guohaoAlgorithm.dynamic;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 21:43
 *
 * 52. N皇后 II
 */
public class TotalNQueens {

    private int ans = 0;
    public int totalNQueens(int n) {
        // 定义棋盘
        LinkedList<char[]> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            Arrays.fill(ch, '.');
            board.add(ch);
        }
        dfs(board, 0);
        return ans;
    }

    private void dfs(LinkedList<char[]> board, int row) {
        if (row == board.size()) {
            ans++;
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (!isValid(board, row, col))
                continue;
            board.get(row)[col] = 'Q';
            dfs(board, row + 1);
            board.get(row)[col] = '.';
        }

    }

    private boolean isValid(LinkedList<char[]> board, int row, int col) {
        int n = board.size();
        // 正上方
        for (int i = 0; i < row; i++) {
            if (board.get(i)[col] == 'Q') return false;
        }
        // 左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q') return false;
        }
        // 右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i)[j] == 'Q') return false;
        }
        return true;
    }
}
