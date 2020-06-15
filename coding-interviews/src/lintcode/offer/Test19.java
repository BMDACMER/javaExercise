package lintcode.offer;

public class Test19 {
    public boolean Find(int target, int[][] array) {
        // 当数组为空时
        if ((array == null) || array.length < 1 || array[0].length < 1)
            return false;



//        for (int i = cols - 1; i >= 0; ) {
//            for (int j = 0; j < rows; ) {
//                if (target < array[j][i]) {
//                    i--;  // 左移
//                } else if (target > array[j][i]) {
//                    j++;  // 下移
//                } else {
//                    return true;
//                }
//            }
        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (target < array[row][col]) {
                    col--;  // 左移
                } else if (target > array[row][col]) {
                    row++;  // 下移
                } else {
                    return true;
                }
        }
        return false;
    }
}
