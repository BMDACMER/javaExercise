package guohaoAlgorithm.slidingwindow;

import com.sun.javafx.image.IntPixelGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 23:19
 *
 * 567. �ַ���������
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * ���������ַ��� s1 �� s2��дһ���������ж� s2 �Ƿ���� s1 �����С�
 *
 * ���仰˵����һ���ַ���������֮һ�ǵڶ����ַ������Ӵ���
 */
public class CheckInclusion {

    /*public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer>  need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // ��s1��Ԫ�ش�ŵ�need��
        for(char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // ��������ָ�� �Լ� valid(��֤�Ƿ�����������
        int left = 0, right = 0, valid = 0;
        int n = s2.length();
        while (right < n) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                // �ж��Ƿ�������ֹ����
                if (valid == need.size()) {
                    return true;
                }

                // ��ָ������
                char d = s2.charAt(left);
                left++;
                // ���д��ڵ�һϵ�в���
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }
        }
        return false;
    }*/

    /**
     * �ж� s2 ���� s1  Ҳ�� s1��s2���ִ�
     * ��������������+˫ָ��
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 1) ����s1��need��
        for (char c : char1) need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, valid = 0;
        // 2) ���ƴ���
        while (right < char2.length) {
            char c = char2[right];
            right++;
            // 2.1 �жϵ�ǰԪ���Ƿ���s1�Ӵ���
            if (need.containsKey(c)) {
                // �ڵĻ� �ͽ����ַ��ŵ����ڣ����жϸ��ַ����ֵĴ�����need���Ƿ����  �������valid++��
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            /*// ����Ҫ����� ����  ��Ȼ������ ˵�����������е��Ӵ��ĳ��ȱ�����need��һ��  ��������ľͲ��ԣ���Ϊ3��
            if (valid == need.size()) {
                return true;
            }*/
            // 3) �ж��󴰿��Ƿ���Ҫ����
            if (right - left >= char1.length) {
                // 4) �жϴ����е��ַ��Ƿ�����need
                if (valid == need.size()) {
                    return true;
                }
               char d = char2[left];
                left++;
                // 5�����д��ڵ�һЩ�и���
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
            }
        }
        // 6) δ�ҵ� ���������� �ִ�
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        System.out.println(c.checkInclusion("abcdxabcde","abcdeabcdx"));;
    }
}
