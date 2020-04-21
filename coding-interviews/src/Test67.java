/**
 *  机器人的运动范围
 */
public class Test67 {

    // 递归
    private int count = 0;
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] vis = new boolean[rows][cols];
       return help(0,0,rows,cols,threshold,vis);
    }

    private int help(int x, int y, int rows, int cols, int threshold, boolean[][] vis) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || vis[x][y] || cul(x, y) > threshold) {
            return 0;
        }
        if (cul(x,y) <= threshold) {
            count++;
            vis[x][y] = true;
        }

        help(x-1,y,rows,cols,threshold,vis);
        help(x+1,y,rows,cols,threshold,vis);
        help(x,y+1,rows,cols,threshold,vis);
        help(x,y-1,rows,cols,threshold,vis);

        return count;
    }

    private int cul(int x, int y) {
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
