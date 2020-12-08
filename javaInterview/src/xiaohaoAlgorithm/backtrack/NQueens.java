package xiaohaoAlgorithm.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/8 9:14
 * 51. N 皇后
 */
public class NQueens {

    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        // 'Q' 和 '.' 分别代表了皇后和空位。
        LinkedList<char[]> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            board.add(chars);
        }

        backtrack(board, 0, n);
        return res;
    }

    // 路径：board中小于row的那些行都已经成功放置了皇后
    // 选择列表：第row行的所有列都是放置皇后的选择
    // 结束条件：row等于board的最后一行，说明棋盘已经放满了
    private void backtrack(LinkedList<char[]> board, int row, int n) {
        // 结束条件
        if (row == n) {
            LinkedList<String> path = new LinkedList<>();
            for (char[] c : board) {
                path.add(new String(c));
            }
            res.add(path);
            return;
        }

        // 选择列表
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col, n))
                continue;

            // 做选择
            board.get(row)[col] = 'Q';
            // 进入下一个决策层
            backtrack(board, row + 1, n);
            // 撤销选择
            board.get(row)[col] = '.';
        }

    }

    // 是否可以在board[row][col]放置皇后？
    private boolean isValid(LinkedList<char[]> board, int row, int col, int n) {
        // 因为皇后是从上往下一行一行防止的，所以只用检查正上方、左上方、右上方三个方向，而不用检查当前行
        // 和下面的三个方向
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board.get(i)[j] == 'Q')
                return false;
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        // 检查正上方是否有皇后互相冲突
        for (int i = row - 1; i >= 0; --i) {
            if (board.get(i)[col] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        NQueens test = new NQueens();
        List<List<String>> lists = test.solveNQueens(n);
        for (List<String> strings : lists) {
            System.out.println(strings);
        }
    }

}
