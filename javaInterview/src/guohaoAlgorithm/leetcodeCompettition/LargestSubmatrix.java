package guohaoAlgorithm.leetcodeCompettition;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/17 17:28
 */
public class LargestSubmatrix {

    /**
     * 预处理数组，计算以这个点为结尾，上面有多少个连续的1，就是这一列以这个点为结尾的最大高度
     * 这样就将二维问题转成一维
     *
     * 遍历每一行，对每一行进行排序，记录矩形的最长的高度，每次更新结果
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
                if(matrix[i][j]==0){ //遍历到0了可直接退出
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
