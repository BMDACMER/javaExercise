package С��;


import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/8 19:23
 */
public class Main2 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] board = new char[rows][cols];
        int i = 0;
        int k = 0;
        for (int j = 0; j < matrix.length; j++) {
            if (k >= cols) {
                i++;
                k = 0;
            }
            board[i][k++] = matrix[j];
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < str.length; j++) {
            sb.append(str[j]);
        }

        return exist(board, sb.toString());
    }

    private boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (solve(board, word, i, j, vis, 0)) {
                    // �ҵ�һ���������
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, String word, int x, int y, boolean[][] vis, int index) {
        // Խ�紦���Լ�ÿ������ֻ�ܷ���һ��
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || vis[x][y]) {
            return false;
        }
        // ƥ�䵽ĳһλ�ò���������
        if (word.charAt(index) != board[x][y]) {
            return false;
        }
        // ƥ��ɹ�
        if (index == word.length() - 1) {
            return true;
        }

        vis[x][y] = true; // x��yλ�õı��
        boolean flag = solve(board, word, x + 1, y, vis, index + 1) ||
                solve(board, word, x - 1, y, vis, index + 1) ||
                solve(board, word, x, y + 1, vis, index + 1) ||
                solve(board, word, x, y - 1, vis, index + 1);
        vis[x][y] = false; // x��yλ�õı��״̬����
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String board = sc.next();
            char[] chars = board.toCharArray();

            int rows = sc.nextInt();
            int cols = sc.nextInt();
            String word = sc.next();
            char[] chars2 = word.toCharArray();
            Main2 m = new Main2();
            m.hasPath(chars,rows, cols, chars2);
        }
    }
}
