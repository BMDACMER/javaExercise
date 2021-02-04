package guohaoAlgorithm.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/4 11:50
 *
 * 438. �ҵ��ַ�����������ĸ��λ��
 * ����һ���ַ��� s ��һ���ǿ��ַ��� p���ҵ� s �������� p ����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
 *
 * �ַ���ֻ����СдӢ����ĸ�������ַ��� s �� p �ĳ��ȶ������� 20100��
 *
 * ˵����
 *
 * ��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 * �����Ǵ������˳��
 * ʾ�� 1:
 *
 * ����:
 * s: "cbaebabacd" p: "abc"
 *
 * ���:
 * [0, 6]
 *
 * ����:
 * ��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
 * ��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
 */
public class FindAnagrams {

    // ��������+˫ָ��
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, valid = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c)))
                    valid++;
            }

            // ��������
            while (right - left >= p.length()) {
                if (valid == need.size())
                    ans.add(left);
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }

        }
        return ans;
    }
}
