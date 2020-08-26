package ���ұ�;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/26 9:28
 *
 * 290  Word Pattern
 * ˼·���� pattern�е�ÿ����ĸ��Ϊhashmap�е�key��str�е�ÿ����ĸ��Ϊvalue
 *
 * ��һ�������� key �ͼ��뵽 HashMap �У��ڶ�������ͬһ�� key���Ǿ��ж�����value �͵�ǰ�����Ƿ�һ��
 *
 * ������������ӳ�� ȷ�� һһ��Ӧ  pattern -- > str /  str ----> pattern
 */
public class ����ģʽ {
    // �������� ����ӳ��
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;

        String[] p = pattern.split("");

        // ��������ӳ��
        return wordPatternMap(p,strs) && wordPatternMap(strs,p);
    }

    // array1��array2��ӳ��
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
     * ����һ���� pattern�е�ÿ����ĸ��Ϊhashmap�е�key��str�е�ÿ����ĸ��Ϊvalue��
     * ��һ�������� key �ͼ��뵽 HashMap �У��ڶ�������ͬһ�� key���Ǿ��ж�����value �͵�ǰ�����Ƿ�һ�¡�
     * ��set���value��ֵ
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
                // �ж�value�Ƿ����
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
