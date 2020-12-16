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
}
