package guohaoAlgorithm.slidingwindow;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 22:39
 *
 * 76. 最小覆盖子串  hard
 */
public class MinWindow {

    /*public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }
        // 记录最小覆盖字串的起始位置即长度
        int len = Integer.MAX_VALUE, start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断窗口是否需要更新
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }*/

    // 14ms  击败62%
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        // 1) 先将字符串t中的字母拷贝到window中
        for (Character c : chart) need.put(c, need.getOrDefault(c,0) + 1);
        int valid = 0, left = 0, right = 0, len = Integer.MAX_VALUE, start = 0;
        while (right < chars.length) {
            char c = chars[right];
            // 右移窗口
            right++;
            // 2） 判断当前字符是否满足need
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 3） 判断左窗口是否需要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // 开始收缩
                char d = chars[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 4) 返回最小覆盖字串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        MinWindow test = new MinWindow();
        System.out.println(test.minWindow("EBBANCF","ABC"));
    }
}
