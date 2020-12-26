package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/26 9:43
 *
 * 85. 最大矩形
 */
public class MaximalRectangle {

    /**
     * 暴力破解
     * 时间复杂度：O（m?n）。
     *
     * 空间复杂度：O（mn）。
     * @param matrix
     * @return
     */
   /* public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        // 定义with[height][with] --- 记录每一行中连续1的最大个数
        int[][] with = new int[matrix.length][matrix[0].length];
        int minCol, height, maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // 若为第一列  则每行连续1的最大个数肯定为1
                    if (j == 0) {
                        with[i][j] = 1;
                    }else {
                        // 否则 当前行的连续1 的个数 等于上一行的个数+1
                        with[i][j] = with[i][j - 1] + 1;
                    }
                } else {
                    // 若不为1 此时设置为0（连续1的个数为0个）
                    with[i][j] = 0;
                }
               // 记录with数组中每一列的最小值
                minCol =  with[i][j];   // 此时初始化
                // 向上扩展
                for (int k = i; k >= 0; --k) {
                    height = i - k + 1;
                    minCol = Math.min(minCol, with[k][j]);
                    maxArea = Math.max(maxArea, height * minCol);
                }
            }
        }
        return maxArea;
    }*/


    /**
     * 借用84题的单调栈求解
     * 思路：对二位数组每一行 都看作 height[i]高度 调用单调栈即可
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[col];
        Arrays.fill(heights, 0);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea (int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int len = heights.length;
        if (len == 1) return heights[0];

        int maxArea = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;   // 重新将heights数组指针指向  newHeights

        Deque<Integer> stack = new ArrayDeque<Integer>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int currentHeight = heights[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, currentHeight * width);
            }
            stack.addLast(i);
        }

        return maxArea;
    }

}
