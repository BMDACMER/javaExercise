package guohaoAlgorithm.oneQuestionPerDay;

import java.util.HashMap;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/2 9:22
 *
 * 424. �滻�����ظ��ַ�
 * ����һ�����ɴ�дӢ����ĸ��ɵ��ַ���������Խ�����λ���ϵ��ַ��滻��������ַ����ܹ�������滻 k �Ρ���ִ�������������ҵ������ظ���ĸ����Ӵ��ĳ��ȡ�
 *
 * ע�⣺�ַ������� �� k ���ᳬ�� 104��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "ABAB", k = 2
 * �����4
 * ���ͣ�������'A'�滻Ϊ����'B',��֮��Ȼ��
 * ʾ�� 2��
 *
 * ���룺s = "AABABBA", k = 1
 * �����4
 * ���ͣ�
 * ���м��һ��'A'�滻Ϊ'B',�ַ�����Ϊ "AABBBBA"��
 * �Ӵ� "BBBB" ����ظ���ĸ, ��Ϊ 4��
 */
public class CharacterReplacement {

    // ��������+˫ָ��
    public int characterReplacement(String s, int k) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        int maxCount = 1, left = 0, right = 0, ans = 0;
        while (right < len) {
            count[arr[right] - 'A']++;
            maxCount = Math.max(maxCount, count[arr[right] - 'A']);
            while (right - left + 1 > maxCount + k) {
                count[arr[left] - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
