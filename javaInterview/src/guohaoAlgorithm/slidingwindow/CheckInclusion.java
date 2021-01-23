package guohaoAlgorithm.slidingwindow;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 23:19
 *
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer>  need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // 将s1中元素存放到need中
        for(char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 定义左右指针 以及 valid(验证是否满足条件）
        int left = 0, right = 0, valid = 0;
        int n = s2.length();
        while (right < n) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                // 判断是否满足终止条件
                if (valid == need.size()) {
                    return true;
                }

                // 做指针右移
                char d = s2.charAt(left);
                left++;
                // 进行窗口的一系列操作
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        c.checkInclusion("abcdxabcde","abcdeabcdx");
    }
}
