package guohaoAlgorithm.½£Ö¸offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @Author guohao
 * @Date 2021/2/20 8:40
 * @Version 1.0
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
