package lintcode.offer;

public class Test19 {
    public boolean Find(int target, int[][] array) {
        // ������Ϊ��ʱ
        if ((array == null) || array.length < 1 || array[0].length < 1)
            return false;



//        for (int i = cols - 1; i >= 0; ) {
//            for (int j = 0; j < rows; ) {
//                if (target < array[j][i]) {
//                    i--;  // ����
//                } else if (target > array[j][i]) {
//                    j++;  // ����
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
                    col--;  // ����
                } else if (target > array[row][col]) {
                    row++;  // ����
                } else {
                    return true;
                }
        }
        return false;
    }
}
