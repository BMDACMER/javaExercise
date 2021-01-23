package guohaoAlgorithm.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 11:07
 *
 * 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 */
public class MaxEnvelopes {

    /**
     * 先对宽升序，在对h降序，接着按照h组成数组，对其求最大子序列
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int n = envelopes.length;
        // 求最大子序列  按照二分查找方法
        int piles = 0;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = envelopes[i][1];
            // 二分查找
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else if (top[mid] == poker){
                    right = mid;
                }
            }

            if (left == piles) piles++;
            top[left] = poker;
        }
        return piles;
    }

}
