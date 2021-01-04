package xiaohaoAlgorithm.simulation;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 14:32
 */
public class IsToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                 if (matrix[i][j] != matrix[i+1][j+1])
                     return false;
            }
        }
        return true;
    }
}
