package ���ұ�;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/26 10:35
 * 205  ͬ���ַ���
 * ����ͬ 290����ģʽ
 */
public class ͬ���ַ��� {

    /**
     * ����һ������hashMap��s--ÿ���ַ���key   t--ÿ���ַ���value
     *  ��һ�������� key �ͼ��뵽 HashMap �У��ڶ�������ͬһ�� key���Ǿ��ж�����value �͵�ǰ�����Ƿ�һ�¡�
     *  ��set���value��ֵ��
     *
     *  Ч�ʽϸ�
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
                // �ж��Ƿ����value
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
     * �������� s--->t �� t ---> s ӳ��  �Դ�ȷ������һһ��Ӧ��ϵ
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
