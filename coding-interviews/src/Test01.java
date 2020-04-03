/**
 * ��Ŀ����
 ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
 ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 �ж��������Ƿ��и�������
 */

public class Test01 {

    // matrix------����    number-------Ҫ���ҵ�����
    public static boolean find(int[][] matrix, int number){
        // �쳣����
        if ((matrix == null) || (matrix.length < 1) || (matrix[0].length < 1)){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;   // ��ʼ����  ��һ�е����һ����
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
        System.out.println(find(matrix, 7));    // Ҫ���ҵ�����������
        System.out.println(find(matrix, 5));    // Ҫ���ҵ�������������
        System.out.println(find(matrix, 1));    // Ҫ���ҵ�������������С������
        System.out.println(find(matrix, 15));   // Ҫ���ҵ�������������������
        System.out.println(find(matrix, 0));    // Ҫ���ҵ�������������С�����ֻ�С
        System.out.println(find(matrix, 16));   // Ҫ���ҵ������������������ֻ���
        System.out.println(find(null, 16));     // ��׳�Բ��ԣ������ָ��
    }
}
