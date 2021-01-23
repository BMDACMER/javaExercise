package guohaoAlgorithm.slidingwindow;

import java.util.HashMap;

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

    public boolean checkInclusion(String s1, String s2) {
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
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        c.checkInclusion("abcdxabcde","abcdeabcdx");
    }
}
