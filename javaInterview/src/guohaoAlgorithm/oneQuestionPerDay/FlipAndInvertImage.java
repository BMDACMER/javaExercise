package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/24 7:47
 * @Version 1.0
 *
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 *
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] tmp = new int[m][n];
        // 1) 逆序---水平翻转
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
        // 2) 反转  --- 0-1  1-0
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
