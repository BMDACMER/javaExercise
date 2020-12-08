package xiaohaoAlgorithm.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/8 9:14
 * 51. N �ʺ�
 */
public class NQueens {

    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        // 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
        LinkedList<char[]> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            board.add(chars);
        }

        backtrack(board, 0, n);
        return res;
    }

    // ·����board��С��row����Щ�ж��Ѿ��ɹ������˻ʺ�
    // ѡ���б���row�е������ж��Ƿ��ûʺ��ѡ��
    // ����������row����board�����һ�У�˵�������Ѿ�������
    private void backtrack(LinkedList<char[]> board, int row, int n) {
        // ��������
        if (row == n) {
            LinkedList<String> path = new LinkedList<>();
            for (char[] c : board) {
                path.add(new String(c));
            }
            res.add(path);
            return;
        }

        // ѡ���б�
        for (int col = 0; col < n; col++) {
            // �ų����Ϸ�ѡ��
            if (!isValid(board, row, col, n))
                continue;

            // ��ѡ��
            board.get(row)[col] = 'Q';
            // ������һ�����߲�
            backtrack(board, row + 1, n);
            // ����ѡ��
            board.get(row)[col] = '.';
        }

    }

    // �Ƿ������board[row][col]���ûʺ�
    private boolean isValid(LinkedList<char[]> board, int row, int col, int n) {
        // ��Ϊ�ʺ��Ǵ�������һ��һ�з�ֹ�ģ�����ֻ�ü�����Ϸ������Ϸ������Ϸ��������򣬶����ü�鵱ǰ��
        // ���������������
        // ������Ϸ��Ƿ��лʺ����ͻ
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board.get(i)[j] == 'Q')
                return false;
        }

        // ������Ϸ��Ƿ��лʺ����ͻ
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        // ������Ϸ��Ƿ��лʺ����ͻ
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
