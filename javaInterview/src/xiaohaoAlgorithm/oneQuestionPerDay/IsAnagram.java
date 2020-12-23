package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.Arrays;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 14:57
 *
 * 242. 有效的字母异位词
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] nums = new int[26];
        Arrays.fill(nums, 0);

        for (int i = 0; i < n; i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (nums[i] != 0)
                return false;
        }

        return true;
    }
}
