package xiaohaoAlgorithm.oneQuestionPerDay;

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
    public int maximalRectangle(char[][] matrix) {
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
    }
}
