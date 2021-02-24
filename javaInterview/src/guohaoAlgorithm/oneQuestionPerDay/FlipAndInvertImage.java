package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/24 7:47
 * @Version 1.0
 *
 * 832. ��תͼ��
 * ����һ�������ƾ��� A����������ˮƽ��תͼ��Ȼ��תͼ�񲢷��ؽ����
 *
 * ˮƽ��תͼƬ���ǽ�ͼƬ��ÿһ�ж����з�ת�����������磬ˮƽ��ת [1, 1, 0] �Ľ���� [0, 1, 1]��
 *
 * ��תͼƬ����˼��ͼƬ�е� 0 ȫ���� 1 �滻�� 1 ȫ���� 0 �滻�����磬��ת [0, 1, 1] �Ľ���� [1, 0, 0]��
 *
 * ʾ�� 1:
 *
 * ����: [[1,1,0],[1,0,1],[0,0,0]]
 * ���: [[1,0,0],[0,1,0],[1,1,1]]
 * ����: ���ȷ�תÿһ��: [[0,1,1],[1,0,1],[0,0,0]]��
 *      Ȼ��תͼƬ: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] tmp = new int[m][n];
        // 1) ����---ˮƽ��ת
        for (int i = 0; i < m; i++) {
            int j = 0, k = n - 1;
            while (j < k) {
                int t = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = t;
                j++;
                k--;
            }
        }
        // 2) ��ת  --- 0-1  1-0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                }else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
