package lintcode.offer;

public class Test31 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 异常处理
        if (rows == 0 || cols == 0)
            return false;

        // 转换二维数组
        char[][] array = buildMatrix(matrix, rows, cols);
        boolean[][] visit = new boolean[rows][cols];   // 标记是否访问  默认为false

        // 开始遍历
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
        // 异常处理   当前下标访问到了字符串的末尾，表示成功匹配（字符串最后一个字符为'\0')
        if (currentIndex == str.length)
            return true;
        // 退出条件 ： 越界，没找到， 已访问过  则都会返回false
        if (r < 0 || r >= array.length || c < 0 || c >= array[0].length
                || array[r][c] != str[currentIndex] || visit[r][c]) {
            return false;
        }

        // 接下来是没被访问过的
        visit[r][c] = true;
        if (find(array, str, visit, currentIndex + 1, r + 1, c) ||
            find(array, str, visit, currentIndex + 1, r - 1, c) ||
            find(array, str, visit, currentIndex + 1, r, c + 1) ||
            find(array, str, visit, currentIndex + 1, r, c - 1)) {
            return true;
        }

        visit[r][c] = false;   // 回溯
        return false;
    }

    // 通过一维数组构建二维数组
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
