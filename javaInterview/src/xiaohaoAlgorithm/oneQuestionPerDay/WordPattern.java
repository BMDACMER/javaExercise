package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/16 14:52
 * 290. 单词规律
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (s.length != pattern.length())
            return false;

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String value = s[i];
            if (map.containsKey(key)) {
                if (!map.get(key).equals(value)) {
                    return false;
                }
            } else {
                // 判断value是否存在
                if (set.contains(value)) {
                    return false;
                }
                map.put(key, value);
                set.add(value);
            }
        }
        return true;
    }

    // 方法二
    public boolean wordPattern2(String pattern, String str) {
        String[] strings = str.split(" ");
        int n = strings.length;
        if (n != pattern.length()) return false;

        HashMap<Character, String> p2s = new HashMap<>();
        HashMap<String, Character> s2p = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char p = pattern.charAt(i);
            String s = strings[i];
            if (p2s.containsKey(p) && !p2s.get(p).equals(s) || s2p.containsKey(s) && s2p.get(s) != p)
                return false;
            p2s.put(p, s);
            s2p.put(s,p);
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern w = new WordPattern();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(w.wordPattern2(pattern, str));
    }
}
