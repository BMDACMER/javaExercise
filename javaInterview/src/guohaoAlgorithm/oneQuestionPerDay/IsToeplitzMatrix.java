package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/22 8:44
 * @Version 1.0
 *
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 示例详见 https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class IsToeplitzMatrix {

    // 暴力算法  居然1ms  击败100%  71.03%
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

    // 官方解答   100% + 95.26%
    /**
     * 进阶问题
     * 对于进阶问题一，一次最多只能将矩阵的一行加载到内存中，我们将每一行复制到一个连续数组中，随后在读取下一行时，
     * 就与内存中此前保存的数组进行比较。
     *
     * 对于进阶问题二，一次只能将不完整的一行加载到内存中，我们将整个矩阵竖直切分成若干子矩阵，
     * 并保证两个相邻的矩阵至少有一列或一行是重合的，然后判断每个子矩阵是否符合要求。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/toeplitz-matrix/solution/tuo-pu-li-ci-ju-zhen-by-leetcode-solutio-57bb/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
