package guohaoAlgorithm.array;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 20:04
 *
 * 407. 接雨水 II
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 *
 *
 * 示例：
 *
 * 给出如下 3x6 的高度图:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * 返回 4 。
 */
public class TrapRainWater {

   /* // 以下是仿造 一维的写的  只能通过16/39   答案不对
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int ans = 0;
        int row = heightMap.length, col = heightMap[0].length;
        int[][] up_max = new int[row][col], down_max = new int[row][col];
        int[][] l_max = new int[row][col], r_max = new int[row][col];
        // base case
        // 最上和最下两行
        for (int i = 0; i < col; i++) {
            up_max[0][i] = heightMap[0][i];
        }
        for (int i = col - 1; i >= 0; i--) {
            down_max[row - 1][i] = heightMap[row - 1][i];
        }
        // 最左边和最右两行
        for (int i = 0; i < row; i++) {
            l_max[i][0] = heightMap[i][0];
        }
        for (int i = row - 1; i >= 0; i--) {
            r_max[i][col - 1] = heightMap[i][col - 1];
        }

        // 以下是四个方向的最值
        // up
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                up_max[i][j] = Math.max(up_max[i-1][j], heightMap[i][j]);
            }
        }
        // down
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                down_max[i][j] = Math.max(down_max[i + 1][j], heightMap[i][j]);
            }
        }
        // l
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                l_max[i][j] = Math.max(l_max[i][j-1], heightMap[i][j]);
            }
        }
        // r
        for (int i = 0; i < row; i++) {
            for (int j = col - 2; j >= 0; j--) {
                r_max[i][j] = Math.max(r_max[i][j + 1], heightMap[i][j]);
            }
        }

        // 比较 取最小值
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += minVale(up_max[i][j], down_max[i][j], l_max[i][j], r_max[i][j]) - heightMap[i][j];
            }
        }

        return ans;
    }

    private int minVale(int up_max, int down_max, int l_max, int r_max) {
        int min = Integer.MAX_VALUE;
        min = Math.min(min, up_max);
        min = Math.min(min, down_max);
        min = Math.min(min, l_max);
        min = Math.min(min, r_max);
        return min;
    }*/

   // 参考：https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/you-xian-dui-lie-de-si-lu-jie-jue-jie-yu-shui-ii-b/
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2)
            return 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt((Cell cell) -> cell.height));
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = visited[i][n-1] = true;
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for (int i = 1; i < n-1; i++) {
            visited[0][i] = visited[m-1][i] = true;
            queue.add(new Cell(0, i, heightMap[0][i]));
            queue.add(new Cell(m-1, i, heightMap[m-1][i]));
        }
        int result = 0;
        int[][] bounds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] bound : bounds) {
                int row = cell.row + bound[0];
                int col = cell.col + bound[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    result += Math.max(0, cell.height - heightMap[row][col]);
                    visited[row][col] = true;
                    queue.add(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TrapRainWater test = new TrapRainWater();
        int[][] nums = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(test.trapRainWater(nums));
    }
}

class Cell {
    int row;
    int col;
    int height;

    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
/*

作者：jackie-tien
        链接：https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/kuo-zhan-1-djie-yu-shui-wen-ti-zhi-2-d-by-jackie-t/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
