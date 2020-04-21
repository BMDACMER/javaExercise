
public class Test67_2 {

    // 非递归
    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 0 || threshold < 0) {
            return 0;
        }
        int cnt = 1;
        boolean[][] vis = new boolean[rows][cols];
        vis[0][0] = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cal(i,j) <= threshold) {
                    if (i - 1 >= 0 && vis[i - 1][j]) {
                        cnt++;
                        vis[i][j] = true;  // 向下
                    } else if (i + 1 < rows && vis[i + 1][j]) {
                        cnt++;
                        vis[i][j] = true;  // 上
                    } else if (j - 1 >= 0 && vis[i][j - 1]) {
                        cnt++;
                        vis[i][j] = true;  // 左
                    } else if (j + 1 < cols && vis[i][j + 1]) {
                        cnt++;
                        vis[i][j] = true; // 右
                    }
                }
            }
        }

        return cnt;
    }

    private int cal(int x, int y) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        while (y != 0) {
            res += y % 10;
            y /= 10;
        }
        return res;
    }

}
