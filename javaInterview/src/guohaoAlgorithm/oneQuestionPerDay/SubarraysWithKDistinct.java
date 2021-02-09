package guohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/9 10:26
 *
 * 992. K 个不同整数的子数组
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 * 提示：
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 */
public class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostWithKDistinct(A, K) - atMostWithKDistinct(A, K - 1);
    }

    /**
     * 最多存在K个不同整数的子区间的个数
     * @param A
     * @param K
     * @return
     */
    private int atMostWithKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];  // 题目要求 1 <= A[i] <= A.length

        int left = 0, right = 0;
        int count = 0, res = 0;   // [left, right)
        while (right < len) {
            if (freq[A[right]] == 0)
                count++;
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0)
                    count--;
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right - left;
        }
        return res;
    }
}
