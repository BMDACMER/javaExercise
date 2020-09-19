package 京东;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/17 20:00
 * 第二题  王子与公主
 * S -- 起始位置
 * E -- 终点位置
 * . -- 通行
 * # -- 障碍物
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.next().charAt(0);
                }
            }
            Main2 test = new Main2();
            int res = test.help(grid);
            if (res > 0)
                System.out.println("YES");
            else
                System.out.println("NO");

            t--;
        }
    }


    public int help(char[][] grid) {
        int x = 0, y = 0, num = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'S') {
                    y = i;
                    x = j;
                    continue;
                }
                if (grid[i][j] == '.')
                    num++;
            }
        }

        return dfs(x, y, num, grid);
    }

    private int dfs(int x, int y, int num, char[][] grid) {
        // 异常处理
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == '#')
            return 0;
        if (grid[y][x] == 'E')
            return num == 0 ? 1 : 0;
        grid[y][x] = '#';
        int res = 0;
        res += dfs(x-1,y,num-1,grid);
        res += dfs(x+1,y,num-1,grid);
        res += dfs(x,y-1,num-1,grid);
        res += dfs(x,y+1,num-1,grid);
        grid[y][x] = '.';
        return res;
    }

}
