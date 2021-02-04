package guohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/4 9:34
 *
 * ��ָ Offer 58 - II. ����ת�ַ���
 * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
 *
 *
 *
 * ʾ�� 1��
 *
 * ����: s = "abcdefg", k = 2
 * ���: "cdefgab"
 * ʾ�� 2��
 *
 * ����: s = "lrloseumgh", k = 6
 * ���: "umghlrlose"
 */
public class ReverseLeftWords {

    // ֱ�ӵ���API
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        return s.substring(n, len) + s.substring(0, n);
    }

    // ������API
    public String reverseLeftWordsII(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    // ���涨ֻʹ�� String����
    public String reverseLeftWordsIII(String s, int n) {
        /*String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;*/
        String res = "";
        for(int i = n; i < n + s.length(); i++)
            res += s.charAt(i % s.length());
        return res;
    }
}
