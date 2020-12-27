package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/27 9:48
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;

        StringBuilder ss = new StringBuilder(s);
        StringBuilder tt = new StringBuilder(t);

        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s2t.containsKey(ss.charAt(i)) && s2t.get(ss.charAt(i)) != tt.charAt(i)
             || t2s.containsKey(tt.charAt(i)) && t2s.get(tt.charAt(i)) != ss.charAt(i))
                return false;

            s2t.put(ss.charAt(i), tt.charAt(i));
            t2s.put(tt.charAt(i), ss.charAt(i));
        }
        return true;
    }
}
