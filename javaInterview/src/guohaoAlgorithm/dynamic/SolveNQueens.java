package guohaoAlgorithm.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/21 20:36
 *
 * 51. N �ʺ�
 */
public class SolveNQueens {

    // �ο���labuladong�㷨С����P48-51
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        // ����һ�����̣�����ʼ��
        LinkedList<char[]> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            Arrays.fill(ch, '.');
            board.add(ch);
        }
        dfs(board, 0);
        return res;
    }

    private void dfs(LinkedList<char[]> board, int row) {
        // ��������
        if (row == board.size()) {
            LinkedList<String> path = new LinkedList<>();
            for (char[] c : board) {
                path.add(new String(c));
            }
            res.add(path);
        }

        int n = board.size();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col))
                continue;
            board.get(row)[col] = 'Q';
            dfs(board, row + 1);
            board.get(row)[col] = '.';
        }
    }

    // �ж����Ϸ������Ϸ�  ���Ϸ��Ƿ�Ϸ�
    private boolean isValid(LinkedList<char[]> board, int row, int col) {
        int n = board.size();
        // ���Ϸ� --- ��
        for (int i = 0; i < row; i++) {
            if (board.get(i)[col] == 'Q')
                return false;
        }
        // ���Ϸ�
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        // ���Ϸ�
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        return true;
    }
}
