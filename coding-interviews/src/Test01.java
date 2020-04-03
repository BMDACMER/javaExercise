/**
 * 题目描述
 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 判断数组中是否含有该整数。
 */

public class Test01 {

    // matrix------矩阵    number-------要查找的数字
    public static boolean find(int[][] matrix, int number){
        // 异常处理
        if ((matrix == null) || (matrix.length < 1) || (matrix[0].length < 1)){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;   // 初始化行  第一行的最后一个数
        int col = cols - 1;

        while ((row < rows) && (col >= 0)){
            if (matrix[row][col] == number){
                return true;
            }else if (matrix[row][col] < number){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));    // 要查找的数在数组中
        System.out.println(find(matrix, 5));    // 要查找的数不在数组中
        System.out.println(find(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println(find(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println(find(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println(find(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println(find(null, 16));     // 健壮性测试，输入空指针
    }
}
