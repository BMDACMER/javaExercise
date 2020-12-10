package xiaohaoAlgorithm.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/10 11:14
 *
 *  ��������ĸ��λ��
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (Character c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();  // ������յĽ��

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }

            // �ж��Ƿ���Ҫ�������ִ�Ϊȫ����  �ж�����Ϊ right - left >= t.size()
            while (right - left >= t.length()) {
                // �����������±���뼴��
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // ���д��������ݵ�һϵ�и���
                if (need.containsKey(d)) {
                    if (window.get(c) == need.get(c)) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }

}
