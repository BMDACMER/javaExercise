package xiaohaoAlgorithm.backtrack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/25 11:45
 *
 * 37. ������
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // ��ٵ����һ�У�תΪ��һ��
            return backtrack(board, i+1, 0);
        }
        if (i == m) {
            // �ҵ�һ�����н⣬���� base case
            return true;
        }

        if (board[i][j] != '.') {
            // r���û��Ԥ�����֣������������
            return backtrack(board, i, j+1);
        }

        for (char ch = '1'; ch < '9'; ch++) {
            // ����������Ϸ������֣�������
            if (!isValid(board, i, j, ch))
                continue;
            board[i][j] = ch;
            // ����ҵ�һ�����н⣬������
            if(backtrack(board, i, j + 1))
                return true;
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // �ж��Ƿ��ظ�
            if (board[r][i] == ch) return false;
            if (board[i][c] == ch) return false;
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == ch)
                return false;
        }
        return true;
    }
}
