package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/18 18:52
 */
public class FindTheDifference {
    /**
     * ˼·��t ���� s �漴���ŵģ�Ȼ��������һ����ĸ��Ҳ���� t��s�ж�һ�������ĸ
     * �����Ƚ�s�еĸ��ַ���hashmap�洢��Ȼ����t�в��ң����������ͬ�� ���ַ�����Ŀ��һ�������������ֱ�ӷ��ظ��ַ�����
     * ʱ�临�Ӷȣ�O(N)
     */
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        // ͳ��s�и��ַ��ĳ��ִ���
        for (Character c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }

        for (Character ch : t.toCharArray()) {
            // ��������� ֱ�ӷ��ؼ��� eg:abcd  abcde  ����e
            if (!map.containsKey(ch)) {
                return ch;
            }else {
                // eg: aa   aaa ����a
                map.put(ch, map.get(ch) - 1);
                // ���ַ����ֵĴ���Ϊ0ʱ�������Ƴ�����
                if (map.get(ch) == 0)
                    map.remove(ch);
            }
        }

        return ' ';
    }

    /**
     * ��������ʱ�临�Ӷ�ΪO(n)
     */
    public char findTheDifference2(String s, String t) {
        int[] chars = new int[26];  // ����26��Сд��ĸ
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
     * ������������
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
