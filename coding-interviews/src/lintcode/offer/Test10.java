package lintcode.offer;

/**
 * 面试题12. 矩阵中的路径
 *
 * 动态规划
 */
public class Test10 {
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }

        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (solve(board, word, i, j, visit, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, String word, int x, int y, boolean[][] visit, int index) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visit[x][y]) {
            return false;
        }

        if (word.charAt(index) != board[x][y]) {
            return false;
        }

        if (index == word.length() - 1)
            return true;

        visit[x][y] = true;
        boolean flag = solve(board, word, x + 1, y, visit, index + 1) ||
                solve(board, word, x - 1, y, visit, index + 1) ||
                solve(board, word, x , y - 1, visit, index + 1) ||
                solve(board, word, x, y + 1, visit, index + 1);
        visit[x][y] = false;
        return flag;
    }
}
