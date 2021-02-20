package guohaoAlgorithm.��ָoffer;

import java.util.HashMap;
/**
 * @Author guohao
 * @Date 2021/2/20 8:40
 * @Version 1.0
 *
 * ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
 *
 * ?
 *
 * ʾ��?1:
 *
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 *
 * ����: "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 *
 * ����: "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ���"wke"�������䳤��Ϊ 3��
 *  ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"��һ�������У������Ӵ���
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char c = chars[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = chars[left];
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        String s = "dvdf";
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
