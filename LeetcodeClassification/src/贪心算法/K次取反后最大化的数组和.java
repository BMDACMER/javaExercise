package 贪心算法;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 17:59
 *
 * 1005 K 次取反后最大化的数组和
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] A, int K) {
        int res = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] = -A[i];
                K--;
            }
        }
        // 因为可以对同一个索引位置i处理 所以在A[i] > 0时 偶数可以抵消，奇数只需要取排序后第一个数即可
        Arrays.sort(A);
        if (K % 2 != 0) {
            A[0] = -A[0];
        }

        // 统计总和
        for (int i = 0; i < A.length; i++) {
            res += A[i];
        }
        return res;
    }
}
