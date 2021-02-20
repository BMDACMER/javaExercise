package guohaoAlgorithm.剑指offer;

import java.util.HashMap;
/**
 * @Author guohao
 * @Date 2021/2/20 8:40
 * @Version 1.0
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * ?
 *
 * 示例?1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *  请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char c = chars[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = chars[left];
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        String s = "dvdf";
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
