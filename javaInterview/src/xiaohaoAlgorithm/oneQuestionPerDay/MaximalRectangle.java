package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/26 9:43
 *
 * 85. ������
 */
public class MaximalRectangle {

    /**
     * �����ƽ�
     * ʱ�临�Ӷȣ�O��m?n����
     *
     * �ռ临�Ӷȣ�O��mn����
     * @param matrix
     * @return
     */
   /* public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        // ����with[height][with] --- ��¼ÿһ��������1��������
        int[][] with = new int[matrix.length][matrix[0].length];
        int minCol, height, maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // ��Ϊ��һ��  ��ÿ������1���������϶�Ϊ1
                    if (j == 0) {
                        with[i][j] = 1;
                    }else {
                        // ���� ��ǰ�е�����1 �ĸ��� ������һ�еĸ���+1
                        with[i][j] = with[i][j - 1] + 1;
                    }
                } else {
                    // ����Ϊ1 ��ʱ����Ϊ0������1�ĸ���Ϊ0����
                    with[i][j] = 0;
                }
               // ��¼with������ÿһ�е���Сֵ
                minCol =  with[i][j];   // ��ʱ��ʼ��
                // ������չ
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
     * ����84��ĵ���ջ���
     * ˼·���Զ�λ����ÿһ�� ������ height[i]�߶� ���õ���ջ����
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
        heights = newHeights;   // ���½�heights����ָ��ָ��  newHeights

        Deque<Integer> stack = new ArrayDeque<Integer>(len);
        // �ȷ����ڱ�����ѭ����Ͳ������ǿ��ж�
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
