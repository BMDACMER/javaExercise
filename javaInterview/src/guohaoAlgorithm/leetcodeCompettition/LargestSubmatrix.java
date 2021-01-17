package guohaoAlgorithm.leetcodeCompettition;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/17 17:28
 */
public class LargestSubmatrix {

    /**
     * Ԥ�������飬�����������Ϊ��β�������ж��ٸ�������1��������һ���������Ϊ��β�����߶�
     * �����ͽ���ά����ת��һά
     *
     * ����ÿһ�У���ÿһ�н������򣬼�¼���ε���ĸ߶ȣ�ÿ�θ��½��
     *
     * @param matrix
     * @return
     */
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);
            for (int j = m - 1; j >= 0; j--) {
                if(matrix[i][j]==0){ //������0�˿�ֱ���˳�
                    break;
                }
                int height = matrix[i][j];
                res = Math.max(res, height * (m - j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestSubmatrix l = new LargestSubmatrix();
        int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};
        System.out.println(l.largestSubmatrix(matrix));
    }
}
