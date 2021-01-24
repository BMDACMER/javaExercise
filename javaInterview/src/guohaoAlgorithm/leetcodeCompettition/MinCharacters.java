package guohaoAlgorithm.leetcodeCompettition;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/24 11:00
 */
public class MinCharacters {

    // 1 <= a.length, b.length <= 105
    //a 和 b 只由小写字母组成
    public int minCharacters(String a, String b) {
        char[] cA = a.toCharArray();
        char[] cB = b.toCharArray();
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (char c : cA) {
            countA[c - 'a']++;
        }
        for (char c : cB) {
            countB[c - 'a']++;
        }
        // 第一种情况
        // 对于a  将i左边的所有元素改为最大值
        // 对于b 将i右边的所有元素改为最小值
        int min1 = help(countA, countB);
        int min2 = help(countB, countA);

        /// 第三种情况
        int min3 = a.length() + b.length();
        for (int i = 0; i < 26; i++) {
            min3 = Math.max(min3, a.length() + b.length() - countA[i] - countB[i]);
        }

        return Math.min(Math.min(min1, min2), min3);
    }

    private int help(int[] countA, int[] countB) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 25; i++) {
            int total = 0;
            for (int j = i+1; j < 26; j++) {
                total += countA[j];
            }
            for (int j = 0; j <= i; j++) {
                total += countB[j];
            }
            ans = Math.min(ans, total);
        }

        return ans;
    }

}
