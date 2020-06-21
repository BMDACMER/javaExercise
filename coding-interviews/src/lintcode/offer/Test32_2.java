package lintcode.offer;

import java.util.Scanner;

/**
 *  机器人运动 ： https://www.nowcoder.com/practice/8314cb12d35b4e2a920b3bd0474fe1f2
 *
 */
public class Test32_2 {

    public int movingCount(int rows, int cols,int threshold) {
        if (rows < 0 || cols < 0 || threshold < 0) {
            return 0;
        }
        int cnt = 1;

        boolean[][] vis = new boolean[rows][cols];
        vis[0][0] = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cul(i,j) <= threshold) {
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

    private int cul(int i, int j) {
        int result = 0;
        while (i != 0) {
            result += i % 10;
            i /= 10;
        }
        while (j != 0) {
            result += j % 10;
            j /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Test32_2 t = new Test32_2();
        Scanner scan = new Scanner(System.in);
        int m, n, k;
//        while (scan.next() != null) {
            m = scan.nextInt();
            n = scan.nextInt();
            k = scan.nextInt();
            System.out.println(t.movingCount(m, n, k));
//        }

    }
}
