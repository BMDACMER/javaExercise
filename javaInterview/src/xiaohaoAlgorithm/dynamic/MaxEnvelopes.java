package xiaohaoAlgorithm.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/11 10:26
 * 354. 俄罗斯套娃信封问题
 */
public class MaxEnvelopes {
    /**
     * 思路：首先对w升序排列，接着在相同的w时，对h降序排列，这样就将问题转换为在h上的子长递增子序列长度的问题
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        // 对高度相同的数组寻找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
