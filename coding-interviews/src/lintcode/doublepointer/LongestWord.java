package lintcode.doublepointer;

import java.util.HashSet;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/7 7:47
 *
 * 524. ͨ��ɾ����ĸƥ�䵽�ֵ��������
 */
public class LongestWord {
    /** // ����д��
    public String findLongestWord(String s, List<String> d) {
        // ����hashset
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        // ��������ͳ���ַ����ֵ���ַ����ĳ��ֳ���
        int[] array = new int[d.size()];
        int index = 0;   // �����±�
        for (String str : d) {
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i))) {
                    array[index]++;
                }
            }
            index++;
        }

        String str = "";
        int maxLen = 0;
        // ���س�������ֵ�˳����С���ַ���
        for (int i = 0; i < array.length; i++) {
            if (maxLen < array[i]){
                maxLen = array[i];
                str = d.get(i);
            } else if (maxLen == array[i]) {
                if (str.compareTo(d.get(i)) > 0) {
                    str = d.get(i);
                }
            }
        }
        return str;
    }
     */

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0))
                continue;
            if (isValid(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isValid(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }


}
