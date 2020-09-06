package 贪心算法;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 18:24
 * 392 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
