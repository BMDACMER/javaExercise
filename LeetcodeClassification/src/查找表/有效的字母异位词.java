package ���ұ�;

import com.sun.javafx.image.IntPixelGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/8/25 22:17
 *
 * 242. ��Ч����ĸ��λ��
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 *
 * ˼·��������hashmap�ֱ�ͳ�������ַ�����Ԫ�س��ִ��������Ƚ�key-value�Ƿ���ȼ���
 */
public class ��Ч����ĸ��λ�� {

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
     * ������
     *
     * ʱ�临�Ӷȣ�O(n)O(n)��ʱ�临�Ӷ�Ϊ O(n)O(n) ��Ϊ���ʼ���������һ���̶���ʱ�������
     * �ռ临�Ӷȣ�O(1)O(1)����������ʹ���˶���Ŀռ䣬���ǿռ�ĸ������� O(1)O(1)����Ϊ���� NN �ж�󣬱�Ĵ�С�����ֲ��䡣
     *
     * ���ߣ�LeetCode
     * ���ӣ�https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
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
