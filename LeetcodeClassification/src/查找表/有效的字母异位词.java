package 查找表;

import com.sun.javafx.image.IntPixelGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/25 22:17
 *
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 思路：用两个hashmap分别统计两个字符串各元素出现次数，最后比较key-value是否相等即可
 */
public class 有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        HashMap<Character, Integer> map1 = new HashMap<>(n);
        HashMap<Character, Integer> map2 = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Character c : s.toCharArray()) {
            if (!map1.get(c).equals(map2.getOrDefault(c,0)))
                return false;
        }
        return true;
    }

    /**
     * 方法二
     *
     * 时间复杂度：O(n)O(n)。时间复杂度为 O(n)O(n) 因为访问计数器表是一个固定的时间操作。
     * 空间复杂度：O(1)O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)O(1)，因为无论 NN 有多大，表的大小都保持不变。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
