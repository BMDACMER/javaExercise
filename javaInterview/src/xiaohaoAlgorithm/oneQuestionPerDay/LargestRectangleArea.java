package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/26 10:13
 *
 * 84. 柱状图中最大的矩形
 *
 * 参考85题  MaximalRectangle
 */
public class LargestRectangleArea {
    /**
     * 暴力法  完全仿造 85题
     *
     * 提交之后  通过36/96    爆内存了
     * @param heights
     * @return
     *//*
    public int largestRectangleArea (int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int width = heights.length;   // 对应列
        int height = heights[0];      // 对应行
        for (int i = 1; i < heights.length; i++) {
            height = Math.max(height, heights[i]);
        }

        int[][] matrix = new int[height][width];
        // 将heights转为 matrix形式   比如：2所在的列 对应 从下往下的两行 1
        for (int i = 0; i < width; i++) {
            int col = heights[i];
            int j = height - 1;
            // 其他未填充的默认为 0
            while (col != 0 && j >= 0) {
                matrix[j][i] = 1;
                col--;
                j--;
            }
        }

        int[][] mark = new int[height][width];
        int maxArea = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    if (j == 0) {
                        mark[i][j] = 1;
                    } else {
                        mark[i][j] = mark[i][j - 1] + 1;
                    }
                } else {
                    mark[i][j] = 0;
                }

                int minCol = mark[i][j];
                // 从下往上扩张
                for (int k = i; k >= 0; k--) {
                    int tempHeight = i - k + 1;
                    minCol = Math.min(minCol, mark[k][j]);
                    maxArea = Math.max(maxArea, tempHeight * minCol);
                }
            }
        }

        return maxArea;
    }*/

    /**
     * 暴力算法   参考：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     * @param heights
     * @return
     */
    /*public int largestRectangleArea (int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int len = heights.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int currentHeight = heights[i];
            while (left > 0 && heights[left - 1] >= currentHeight) {
                left--;
            }

            // 找右边最后一个大于等于 heights[j]的下标
            int right = i;
            while (right < len - 1 && heights[right + 1] >= currentHeight) {
                right++;
            }

            int width = right - left + 1;
            maxArea = Math.max(maxArea, width * currentHeight);
        }
        return maxArea;
    }*/

    /**
     * 采用单调栈   优化结果O(N) + O(N)
     * @param heights
     * @return
     */
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

    public static void main(String[] args) {
        LargestRectangleArea test = new LargestRectangleArea();
        int[] height = {2,1,5,6,2,3};
        int i = test.largestRectangleArea(height);
        System.out.println(i);
    }

}
