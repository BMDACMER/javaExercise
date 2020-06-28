package lintcode.offer;
import java.util.ArrayList;

public class Test49 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];  // 默认为false
        ArrayList<Integer> list = new ArrayList<>();   // 用来存放结果数组
        int flag = 1;   // 1-->right   2--->down   3--->left   4--->up
        int x = 0, y = 0;   // 记录作表，初始化为（0，0）坐标
        while (list.size() < matrix.length * matrix[0].length) {
            // 越界
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visit[x][y]) {
                if (flag == 1) { // 移动到最右端
                    flag = 2;   // 向下
                    x++;
                    y--;  // 消除越界影响
                } else if (flag == 2) {
                    flag = 3; // 向左
                    x--;   // 消除越界影响
                    y--;
                } else if (flag == 3) {
                    flag = 4;  // 向上
                    x--;  // 消除越界影响
                    y++;
                } else if (flag == 4) {
                    flag = 1;  // 向右
                    x++;
                    y++; // 消除越界影响
                }
            } else {
                list.add(matrix[x][y]);
                visit[x][y] = true;
                if (flag == 1)
                    y++;
                if (flag == 2)
                    x++;
                if (flag == 3)
                    y--;
                if (flag == 4)
                    x--;
            }
        }
        return list;
    }
}
