package lintcode.offer;

/**
 * 面试题04： 二维数组中的查找
 */
public class Test02 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if ((matrix == null) || (matrix.length < 1) || (matrix[0].length < 1)){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            } else if (target == matrix[row][col]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(arr, 25));

    }
}
