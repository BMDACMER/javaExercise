package lintcode.doublepointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/2 13:08
 *
 * 345. ��ת�ַ����е�Ԫ����ĸ
 *
 * ��дһ�����������ַ�����Ϊ���룬��ת���ַ����е�Ԫ����ĸ��
 */
public class ReverseVowelsOfString {
    private final static HashSet<Character> vowels =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }

        return new String(result);
    }
}
