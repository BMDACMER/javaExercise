package guohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/10 9:39
 *
 * 567. �ַ���������
 * ���������ַ��� s1 �� s2��дһ���������ж� s2 �Ƿ���� s1 �����С�
 *
 * ���仰˵����һ���ַ���������֮һ�ǵڶ����ַ������Ӵ���
 *
 * ʾ��1:
 *
 * ����: s1 = "ab" s2 = "eidbaooo"
 * ���: True
 * ����: s2 ���� s1 ������֮һ ("ba").
 *
 *
 * ʾ��2:
 *
 * ����: s1= "ab" s2 = "eidboaoo"
 * ���: False
 *
 *
 * ע�⣺
 *
 * ������ַ���ֻ����Сд��ĸ
 * �����ַ����ĳ��ȶ��� [1, 10,000] ֮��
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) need.put(c, need.getOrDefault(c,0) + 1);

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (need.get(c).equals(window.get(c)))
                    valid++;
            }

            // ��������ʱ  ����
            while (right - left >= s1.length()) {
                if (valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
