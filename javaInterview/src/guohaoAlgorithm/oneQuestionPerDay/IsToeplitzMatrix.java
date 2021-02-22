package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/22 8:44
 * @Version 1.0
 *
 * 766. �������ľ���
 * ����һ�� m x n �ľ��� matrix ���������������������ľ��󣬷��� true �����򣬷��� false ��
 *
 * ���������ÿһ�������ϵ����µĶԽ����ϵ�Ԫ�ض���ͬ����ô��������� �������ľ��� ��
 *
 * ʾ����� https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class IsToeplitzMatrix {

    // �����㷨  ��Ȼ1ms  ����100%  71.03%
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int base = matrix[i][j];
                visited[i][j] = true;
                int k1 = i + 1, k2 = j + 1;
                while (k1 < m && k2 < n && !visited[k1][k2]) {
                    if (base != matrix[k1][k2])
                        return false;
                    visited[k1][k2] = true;
                    k1++;
                    k2++;
                }
            }
        }
        return true;
    }

    // �ٷ����   100% + 95.26%
    /**
     * ��������
     * ���ڽ�������һ��һ�����ֻ�ܽ������һ�м��ص��ڴ��У����ǽ�ÿһ�и��Ƶ�һ�����������У�����ڶ�ȡ��һ��ʱ��
     * �����ڴ��д�ǰ�����������бȽϡ�
     *
     * ���ڽ����������һ��ֻ�ܽ���������һ�м��ص��ڴ��У����ǽ�����������ֱ�зֳ������Ӿ���
     * ����֤�������ڵľ���������һ�л�һ�����غϵģ�Ȼ���ж�ÿ���Ӿ����Ƿ����Ҫ��
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/toeplitz-matrix/solution/tuo-pu-li-ci-ju-zhen-by-leetcode-solutio-57bb/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
