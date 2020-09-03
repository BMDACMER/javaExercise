package ������ȹ������;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 8:40
 * 130 ��Χ�Ƶ�����
 * ����һ��DFS
 * ˼·�����Խ������е�o���Ϊ���࣬һ���Ǳ�xΧ�Ƶģ�һ����o�ڱ߽������߽�o������
 * ��һ������ǣ������ϽǱ߽翪ʼ���������ڶ���o���Ϊ#����һ��o���ֲ��ˣ�����һ�α�����ɺ󣬾�����Ԫ��ΪX�� O�� #
 * �ڶ�����ת���������Ϊo�ĸ�ΪX���ٽ����Ϊ#�ĸ�Ϊo����
 */
public class ��Χ�Ƶ����� {

    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};  // ��������
    int m;
    int n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;  // ��
        n = board[0].length;  // ��
        // 1 ���
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j ==0 || j == n - 1) && board[i][j] == 'O')
                    dfs(i, j, board);
            }
        }

        // 2 ת��
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
        // �߽���ΪX��
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] != 'O')
            return;

        board[i][j] = '#';
        // ������ȱ���
        for (int[] direct : directions){
            dfs(i + direct[0], j + direct[1], board);
        }
    }
}
