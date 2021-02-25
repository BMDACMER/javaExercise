package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/25 9:43
 * @Version 1.0
 *
 *
 * 867. ת�þ���
 * ����һ����ά�������� matrix�� ���� matrix �� ת�þ��� ��
 *
 * ����� ת�� ��ָ����������Խ��߷�ת���������������������������
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
