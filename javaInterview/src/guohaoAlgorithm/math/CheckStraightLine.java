package guohaoAlgorithm.math;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/17 9:40
 * <p>
 * 1232. ×ºµã³ÉÏß   easy
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        int x3, y3;
        for (int i = 2; i < coordinates.length; i++) {
            x3 = coordinates[i][0];
            y3 = coordinates[i][1];

            if ((y2 - y1)*(x3 - x2) != (y3 - y2)*(x2 - x1)) {
                return false;
            }

            x1 = x2;
            y1 = y2;
            x2 = x3;
            y2 = y3;
        }

        return true;
    }
}
