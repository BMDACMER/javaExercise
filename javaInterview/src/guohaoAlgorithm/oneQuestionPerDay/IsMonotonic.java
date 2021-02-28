package guohaoAlgorithm.oneQuestionPerDay;

/**
 * @Author guohao
 * @Date 2021/2/28 9:10
 * @Version 1.0
 *
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 */
public class IsMonotonic {

    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if (n == 1) return true;

        int increase = 1, decrease = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] - A[i - 1] >= 0) {
                increase++;
            }
            if (A[i] - A[i - 1] <= 0) {
                decrease++;
            }
        }

        return increase == n || decrease == n;
    }

    // 优化算法  ---- 击败100%
    public boolean isMonotonic2(int[] A) {
        return isSorted(A, true) || isSorted(A, false);
    }

    public boolean isSorted(int[] A, boolean increasing) {
        int n = A.length;
        if (increasing) {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < n - 1; ++i) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
