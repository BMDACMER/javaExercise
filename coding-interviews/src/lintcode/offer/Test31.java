package lintcode.offer;

public class Test31 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // �쳣����
        if (rows == 0 || cols == 0)
            return false;

        // ת����ά����
        char[][] array = buildMatrix(matrix, rows, cols);
        boolean[][] visit = new boolean[rows][cols];   // ����Ƿ����  Ĭ��Ϊfalse

        // ��ʼ����
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (find(array, str, visit, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] array, char[] str, boolean[][] visit, int currentIndex, int r, int c) {
        // �쳣����   ��ǰ�±���ʵ����ַ�����ĩβ����ʾ�ɹ�ƥ�䣨�ַ������һ���ַ�Ϊ'\0')
        if (currentIndex == str.length)
            return true;
        // �˳����� �� Խ�磬û�ҵ��� �ѷ��ʹ�  �򶼻᷵��false
        if (r < 0 || r >= array.length || c < 0 || c >= array[0].length
                || array[r][c] != str[currentIndex] || visit[r][c]) {
            return false;
        }

        // ��������û�����ʹ���
        visit[r][c] = true;
        if (find(array, str, visit, currentIndex + 1, r + 1, c) ||
            find(array, str, visit, currentIndex + 1, r - 1, c) ||
            find(array, str, visit, currentIndex + 1, r, c + 1) ||
            find(array, str, visit, currentIndex + 1, r, c - 1)) {
            return true;
        }

        visit[r][c] = false;   // ����
        return false;
    }

    // ͨ��һά���鹹����ά����
    private char[][] buildMatrix(char[] matrix, int rows, int cols) {
        char[][] array = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = matrix[k++];
            }
        }
        return array;
    }
}
