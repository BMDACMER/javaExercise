package xiaohaoAlgorithm.oneQuestionPerDay;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/26 9:43
 *
 * 85. ������
 */
public class MaximalRectangle {

    /**
     * �����ƽ�
     * ʱ�临�Ӷȣ�O��m?n����
     *
     * �ռ临�Ӷȣ�O��mn����
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        // ����with[height][with] --- ��¼ÿһ��������1��������
        int[][] with = new int[matrix.length][matrix[0].length];
        int minCol, height, maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // ��Ϊ��һ��  ��ÿ������1���������϶�Ϊ1
                    if (j == 0) {
                        with[i][j] = 1;
                    }else {
                        // ���� ��ǰ�е�����1 �ĸ��� ������һ�еĸ���+1
                        with[i][j] = with[i][j - 1] + 1;
                    }
                } else {
                    // ����Ϊ1 ��ʱ����Ϊ0������1�ĸ���Ϊ0����
                    with[i][j] = 0;
                }
               // ��¼with������ÿһ�е���Сֵ
                minCol =  with[i][j];   // ��ʱ��ʼ��
                // ������չ
                for (int k = i; k >= 0; --k) {
                    height = i - k + 1;
                    minCol = Math.min(minCol, with[k][j]);
                    maxArea = Math.max(maxArea, height * minCol);
                }
            }
        }
        return maxArea;
    }
}
