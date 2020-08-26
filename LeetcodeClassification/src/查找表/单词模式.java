package 查找表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/26 9:28
 *
 * 290  Word Pattern
 * 思路：将 pattern中的每个字母作为hashmap中的key，str中的每个字母作为value
 *
 * 第一次遇到的 key 就加入到 HashMap 中，第二次遇到同一个 key，那就判断它的value 和当前单词是否一致
 *
 * 方法二：两次映射 确定 一一对应  pattern -- > str /  str ----> pattern
 */
public class 单词模式 {
    // 方法二： 两次映射
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;

        String[] p = pattern.split("");

        // 两个方向映射
        return wordPatternMap(p,strs) && wordPatternMap(strs,p);
    }

    // array1到array2的映射
    private boolean wordPatternMap(String[] array1, String[] array2) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            String key = array1[i];
            if (map.containsKey(key)) {
                if (!map.get(key).equals(array2[i])) {
                    return false;
                }
            } else {
                map.put(key, array2[i]);
            }
        }
        return true;
    }

    /**
     * 方法一：将 pattern中的每个字母作为hashmap中的key，str中的每个字母作为value，
     * 第一次遇到的 key 就加入到 HashMap 中，第二次遇到同一个 key，那就判断它的value 和当前单词是否一致。
     * 用set存放value的值
     */
    public boolean isWordPattern(String pattern, String str) {
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
