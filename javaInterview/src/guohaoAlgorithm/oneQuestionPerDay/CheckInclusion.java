package guohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/10 9:39
 *
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) need.put(c, need.getOrDefault(c,0) + 1);

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (need.get(c).equals(window.get(c)))
                    valid++;
            }

            // 满足条件时  收缩
            while (right - left >= s1.length()) {
                if (valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
