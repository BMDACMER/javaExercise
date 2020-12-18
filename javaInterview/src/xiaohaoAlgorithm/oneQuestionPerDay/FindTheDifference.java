package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/18 18:52
 */
public class FindTheDifference {
    /**
     * 思路：t 是由 s 随即重排的，然后随机添加一个字母，也就是 t比s中多一个随机字母
     * 可以先将s中的各字符用hashmap存储，然后在t中查找，如果遇到相同的 则字符的数目减一，如果不存在则直接返回该字符即可
     * 时间复杂度：O(N)
     */
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 统计s中各字符的出现次数
        for (Character c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }

        for (Character ch : t.toCharArray()) {
            // 如果不存在 直接返回即可 eg:abcd  abcde  返回e
            if (!map.containsKey(ch)) {
                return ch;
            }else {
                // eg: aa   aaa 返回a
                map.put(ch, map.get(ch) - 1);
                // 当字符出现的次数为0时，则将其移除即可
                if (map.get(ch) == 0)
                    map.remove(ch);
            }
        }

        return ' ';
    }

    /**
     * 方法二：时间复杂度为O(n)
     */
    public char findTheDifference2(String s, String t) {
        int[] chars = new int[26];  // 包括26个小写字母
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if(--chars[t.charAt(i) - 'a'] < 0)
                return t.charAt(i);
        }

        return 0;
    }

    /**
     * 方法三：技巧
     */
    public char findTheDifference3(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray())
            res ^= c;
        for (char c : t.toCharArray())
            res ^= c;

        return res;
    }
}
