package lintcode.offer;

/**
 * 机器人运动
 * 思路：将格子里的数字拆分求和，具体来讲就是将行列坐标都拆分并求和，与给定的数字作比较
 * sum < k 则 格子数+1，继续遍历。可以采用DFS
 */
public class Test32 {

    private int count = 0;

    public int movingCount(int threshold, int rows, int cols) {

        boolean[][] visit = new boolean[rows][cols];   // 标记是否访问过，默认为false；
        help(threshold,visit,0,0, rows, cols);

        return count;
    }

    private void help(int threshold, boolean[][] visit, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || getTotal(r,c) > threshold || visit[r][c]) {
            return ;
        }
        if (getTotal(r, c) <= threshold){
            count++;
            visit[r][c] = true;
        }
        help(threshold, visit, r + 1, c, rows, cols);
        help(threshold, visit, r - 1, c, rows, cols);
        help(threshold, visit, r, c + 1, rows, cols);
        help(threshold, visit, r, c - 1, rows, cols);

    }

    // 对坐标上的位数求和
    private int getTotal(int r, int c) {
        int result = 0;
        while (r != 0) {
            result += r % 10;
            r /= 10;
        }
        while (c != 0) {
            result += c % 10;
            c /= 10;
        }
        return result;
    }

}
