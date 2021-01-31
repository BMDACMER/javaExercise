package guohaoAlgorithm.backtrack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/30 17:40
 *
 * 37. ������
 * ��дһ������ͨ�����ո�������������⡣
 *
 * һ�������Ľⷨ����ѭ���¹���
 *
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
 * �հ׸��� '.' ��ʾ��
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
       helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        // ������������Ҷˣ��Ϳ�ʼ������һ��
        if (j == n) {
            return helper(board, i + 1, 0);
        }
        // ������������һ�У���ʾ����  base case
        if (i == m) {
            return true;
        }
        // �����λ����Ԥ������֣����ù�
        if (board[i][j] != '.') {
            return helper(board, i, j + 1);
        }

        for(char ch = '1'; ch <= '9'; ++ch) {
            // ����������Ϸ�����  ����
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            // ��ѡ��
            board[i][j] = ch;
            // ��ʼ�����һ��
            if (helper(board, i, j + 1)) return true;
            // ������һ����
            board[i][j] = '.';
        }
        // �����1-9����Ȼû���ҵ����н⣬��Ҫǰ��ĸ��ӻ����������
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // �ж����Ƿ�����ظ�
            if (board[r][i] == ch) return false;
            // �ж����Ƿ��ظ�
            if (board[i][c] == ch) return false;
            // �ж��Ƿ�������С������
            if (board[(r/3)*3 + i / 3][(c/3)*3 + i % 3] == ch) return false;
        }
        return true;
    }
}
