package xiaohaoAlgorithm.slidingwindow;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/10 10:12
 *
 *  76. ��С�����Ӵ�
 */
public class MinSubStr {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c :  t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        // ��¼��С�����ִ�����ʼ����������
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // �ж�ȡ�����ַ��Ƿ����ִ���
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }

            // �ж��Ƿ���Ҫ�������Ѿ��ҵ����ʵĸ��Ǵ���
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1) == need.get(c1)) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len);
    }
}
