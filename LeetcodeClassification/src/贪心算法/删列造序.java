package 贪心算法;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 10:33
 * 944 删列造序
 *
 */
public class 删列造序 {
    /**
     * 思路：对于每一列，我们检查它是否是有序的。如果它有序，则将答案增加 1，否则它必须被删除。
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是数组 A 中的元素个数。
     *
     * 空间复杂度：O(1)O(1)。
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        int res = 0;
        int col = A[0].length();
        int row = A.length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (A[j].charAt(i) - A[j + 1].charAt(i) > 0) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
