package xiaohaoAlgorithm.greedy;

import javafx.beans.binding.StringBinding;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 10:17
 *
 * 944. ɾ������
 */
public class MinDeletionSize {

    /**
     * �����㷨
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        int min = 0;
        int row = A.length;
        int col = A[0].length();
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            char[] chars = A[i].toCharArray();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = chars[j];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (matrix[j][i] > matrix[j + 1][i]) {
                    min++;
                    break;
                }
            }
        }

        return min;
    }


    //  �Ż�����   ���ַ�����תΪ�ַ���
    public int minDeletionSize2(String[] A) {
        int min = 0;
        int col = A[0].length();
        StringBuilder sb = new StringBuilder();
        // ���ַ�����תΪ�ַ���
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]);
        }

        for (int i = 0; i < col; i++) {
            for (int j = i; j < sb.length() - col; j += col) {
                if (sb.charAt(j) > sb.charAt(j + col)) {
                    min++;
                    break;
                }
            }
        }

        return min;
    }
}
