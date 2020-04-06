import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Test19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];   // 标记访问数组
        ArrayList<Integer> ans = new ArrayList<>();   // 存放返回的结果
        int flag = 1;   // 1---> right  2-->down   3--->left    4---> up
        int x = 0, y = 0;   // 初始化位置

        while (ans.size() <= matrix.length * matrix[0].length) {   // 直到存放完所有的数据为止
            // 越界
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visit[x][y]) {
                if (flag == 1) {
                    flag = 2; // down
                    y--;   // 消除越界的影响    毕竟此时的y已经越界了
                    x++;  // 下移
                } else if (flag == 2) {
                    flag = 3;
                    x--;    // x越界了，消除越界影响
                    y--;    // 左移
                } else if (flag == 3) {
                    flag = 4;
                    y++;   // y<0   消除越界影响
                    x--;   // 上移
                } else {
                    flag = 1;
                    x++;   // x<0  消除越界影响
                    y--;   // 右移
                }
            } else {
                ans.add(matrix[x][y]);
                visit[x][y] = true;
                if (flag == 1) {
                    y++;
                } else if (flag == 2) {
                    x++;
                } else if (flag == 3) {
                    y--;
                } else {
                    x--;
                }
            }

        }
        return ans;
    }
}
