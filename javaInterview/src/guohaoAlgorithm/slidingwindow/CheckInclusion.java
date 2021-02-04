package guohaoAlgorithm.slidingwindow;

import com.sun.javafx.image.IntPixelGetter;

import java.util.HashMap;
import java.util.Map;

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

    /*public boolean checkInclusion(String s1, String s2) {
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
    }*/

    /**
     * 判断 s2 包含 s1  也即 s1是s2的字串
     * 方法：滑动窗口+双指针
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 1) 拷贝s1到need中
        for (char c : char1) need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, valid = 0;
        // 2) 右移窗口
        while (right < char2.length) {
            char c = char2[right];
            right++;
            // 2.1 判断当前元素是否在s1子串中
            if (need.containsKey(c)) {
                // 在的话 就将该字符放到窗口，并判断该字符出现的次数与need中是否相等  若满足就valid++；
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            /*// 题意要求的是 排列  既然是排列 说明滑动窗口中的子串的长度必须与need中一样  所以下面的就不对，改为3）
            if (valid == need.size()) {
                return true;
            }*/
            // 3) 判断左窗口是否需要收缩
            if (right - left >= char1.length) {
                // 4) 判断窗口中的字符是否满足need
                if (valid == need.size()) {
                    return true;
                }
               char d = char2[left];
                left++;
                // 5）进行窗口的一些列更新
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }
        // 6) 未找到 符合条件的 字串
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        System.out.println(c.checkInclusion("abcdxabcde","abcdeabcdx"));;
    }
}
