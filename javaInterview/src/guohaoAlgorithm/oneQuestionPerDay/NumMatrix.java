package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/3/2 9:22
 * @Version 1.0
 *
 *
 * 304. ��ά����ͼ��� - ���󲻿ɱ�
 * ����һ����ά���󣬼������Ӿ��η�Χ��Ԫ�ص��ܺͣ����Ӿ�������Ͻ�Ϊ (row1, col1) �����½�Ϊ (row2, col2) ��
 *
 * Range Sum Query 2D
 * ��ͼ�Ӿ������Ͻ� (row1, col1) = (2, 1) �����½�(row2, col2) = (4, 3)�����Ӿ�����Ԫ�ص��ܺ�Ϊ 8��
 *
 * ʾ����
 *
 * ���� matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * �㷨˼�뻹�� ǰ׺��
 */
public class NumMatrix {

    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+1][j+1] = sum[i][j+1]+sum[i+1][j]+matrix[i][j]-sum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
}
