package 查找表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/26 10:35
 * 205  同构字符串
 * 方法同 290单词模式
 */
public class 同构字符串 {

    /**
     * 方法一：采用hashMap，s--每个字符做key   t--每个字符做value
     *  第一次遇到的 key 就加入到 HashMap 中，第二次遇到同一个 key，那就判断它的value 和当前单词是否一致。
     *  用set存放value的值。
     *
     *  效率较高
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);

            if (map.containsKey(key)) {
                if (!map.get(key).equals(value))
                    return false;
            } else {
                // 判断是否存在value
                if (set.contains(value)) {
                    return false;
                }
                map.put(key, value);
                set.add(value);
            }
        }
        return true;
    }

    /**
     * 方法二： s--->t 与 t ---> s 映射  以此确定两者一一对应关系
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length())
            return false;

        String[] array1 = s.split("");
        String[] array2 = t.split("");

        return isomorphicHelp(array1, array2) && isomorphicHelp(array2, array1);
    }

    private boolean isomorphicHelp(String[] array1, String[] array2) {
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


}
