package lintcode.offer;

/**
 * 面试题13. 机器人的运动范围
 *
 *
 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 例如，当k为18时，机器人能够进入方格 [35, 37] ， 因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Test11 {

    public int movingCount(int m, int n, int k) {
        int count = 1;
        if (m < 1 || n < 1 || m > 100 || n > 100 || k < 0 || k > 20)
            return -1;
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (help(i,j) <= k) {
                    if (i - 1 >= 0 && visit[i-1][j]) {
                        count++;
                        visit[i][j] = true;  // 向下
                    } else if (j - 1 >= 0 && visit[i][j-1]) {
                        count++;
                        visit[i][j] = true;  // 向右
                    }
                }
            }
        }
        return count;
    }


    // 坐标数字各位相加
    private int help(int i, int j) {
        int result = 0;
        while (i != 0) {
            result += i % 10;
            i /= 10;
        }
        while (j != 0) {
            result += j % 10;
            j /= 10;
        }
        return  result;
    }

}
