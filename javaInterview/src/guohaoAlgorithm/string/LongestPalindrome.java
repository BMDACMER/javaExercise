package guohaoAlgorithm.string;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/31 22:22
 *
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 寻找长度为奇数的回文字串
            String s1 = palindrome(s, i, i);
            // 寻找长度为偶数的回文字串
            String s2 = palindrome(s, i, i + 1);

            ans = ans.length() >= s1.length() ? ans : s1;
            ans = ans.length() >= s2.length() ? ans : s2;
        }

        return ans;
    }

    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        int start = l + 1;
        int end = r;
        return start <= end ? s.substring(start, end) : "";
    }
}
