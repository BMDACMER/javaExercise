package guohaoAlgorithm.unionfind;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/11 17:20
 *
 * 130 ��Χ�Ƶ�����
 */
public class SurroundedArea {

    /**
     * ���鼯
     *  �ο���P410
     * �ȼ���һ��dummy�ڵ���Ϊ����������Ȧ��"O" ��dummy���ӣ�������ʣ��Ľڵ㣬���û����ͨ����o��Ϊx
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0) return;
        // ��Ϊ���鼯��һά�� ��������Ҫ�� board��ά����תΪһά��
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;
        // ����һ�к����һ�� �е� O
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                uf.union(i, dummy);
            if (board[m - 1][i] == 'O')
                uf.union(n * (m - 1) + i, dummy);
        }

        // ����һ�к����һ�� �е� O ��dummy��ͨ
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }

        // ��������d���������������ĸ�����ĳ����ַ�
        int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    // ���� O ���������ҵ� O��ͨ
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O')
                            uf.union(x*n+y, i*n+j);

                    }
                }
            }

        }

        // ����û����X��Χ�� O ���� dummy��ͨ
        // ���в���dummy��ͬ��o��Ҫ���滻
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connect(dummy, i * n + j))
                    board[i][j] = 'X';
            }
        }
    }

    /**
     * dfs ����
     */
    public void dfs(char[][] board) {
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        dfs(board, m, n);
        // �ѵ�һ�к����һ�й�����O��Ϊ#
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        // �ѵ�һ�к����һ�� ������ O��Ϊ#
        for (int j = 0; j < m; j++) {
            dfs(board, j, 0);
            dfs(board, j, n - 1);
        }

        // ʣ�µ�O����Ӧ�����滻����
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    // ��������d���������������ĸ�����ĳ����ֶ�
    int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        if (board[i][j] != 'O') return;

        // ����ת��
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            dfs(board, i + d[k][0], j + d[k][1]);
        }
    }
}
