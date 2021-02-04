package guohaoAlgorithm.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/23 10:01
 *
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {

    // 昨天用暴力算法解决了  今天采用滑动窗口方法
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) return 0;
        HashSet<Character> window = new HashSet<>();
        int left = 0, right = 0, len = Integer.MIN_VALUE;
        int n = s.length();
        char[] chars = s.toCharArray();
        while (left < n) {
            if (left != 0) {
                window.remove(chars[left - 1]);
            }
            while (right < n && !window.contains(chars[right])) {
                window.add(chars[right]);
                right++;
            }

            len = Math.max(len, right - left);
            left++;
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String str = "abcbabcbb";
        System.out.println(l.lengthOfLongestSubstring(str));
    }

    // 方法二  参考P95
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
