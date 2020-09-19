package 京东;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/17 19:44
 */
public class Main {

    int m, n;
    int[][] vis;
    int ans = 0;
    int[][] dis = {{-1,0},{0,1},{1,0},{0,-1}};
    public int help(char[][] grid) {
        //1.统计0的个数，记录起始位置
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        int x = 0, y = 0, num = 0;
        vis = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'S') {
                    x = i;
                    y = j;
                }
                if(grid[i][j] == '.') {
                    num++;
                }
            }
        }
        vis[x][y] = 'S';
        dfs(x, y, num+2, grid, 1);
        return ans;
    }

    private void dfs(int x, int y, int num, char[][] grid, int count) {
        if(grid[x][y] == 'E' && count == num) {
            ans++;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dis[i][0];
            int ny = y + dis[i][1];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && vis[nx][ny] == 0 && (grid[nx][ny] == '.' || grid[nx][ny] == 'E')) {
                vis[nx][ny] = 1;
                count++;
                dfs(nx, ny, num, grid, count);
                vis[nx][ny] = 0;
                count--;
            }
        }
    }

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
            Main test = new Main();
            int res = test.help(grid);
            if (res != 0)
                System.out.println("YES");
            else
                System.out.println("NO");

            t--;
        }
    }

}

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, stepNum = 1;  //当grid[i][j] == 2, stepNum++, 这里直接初始化为1
        //遍历获取起始位置和统计总步数
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    startY = i;
                    startX = j;
                    continue;
                }
                if (grid[i][j] == 0) stepNum++;
            }
        }

        return dfs(startX, startY, stepNum, grid);
    }


    public int dfs(int x, int y, int stepSur, int[][] grid){
        //排除越界的情况和遇到障碍的情况
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == -1) return 0;
        if (grid[y][x] == 2) return stepSur == 0 ? 1 : 0;
        grid[y][x] = -1;  //已走过的标记为障碍
        int res = 0;
        res += dfs(x - 1, y, stepSur - 1, grid);
        res += dfs(x + 1, y, stepSur - 1, grid);
        res += dfs(x, y - 1, stepSur - 1, grid);
        res += dfs(x, y + 1, stepSur - 1, grid);
        grid[y][x] = 0;  //dfs遍历完该位置为起始位置的情况后，置零，以不影响后面的dfs
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            Solution s = new Solution();
            int res = s.uniquePathsIII(arr);
            System.out.println(res);


            t--;
        }
    }
}


