package lintcode.offer;

/**
 * ������05. �滻�ո�
 *
 * ��ʵ��һ�����������ַ��� s �е�ÿ���ո��滻��"%20"��
 *
 * ���룺s = "We are happy."
   �����"We%20are%20happy."
 */
public class Test03 {
    // ��һ�� ����������
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();

    }

    // ������  ����Ԫ��ֻ�ƶ�һ��
    public String replaceSpace2(String s) {
        if (s == null || s.length() < 1)
            return null;

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch);
        }

        // ͳ�ƿո�
        int countBlank = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                countBlank++;
            }
        }

        int strNewLen = sb.length() + 2 * countBlank;
        sb.setLength(strNewLen);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(--strNewLen,'0');
                sb.setCharAt(--strNewLen,'2');
                sb.setCharAt(--strNewLen,'%');
            } else {
                sb.setCharAt(--strNewLen,sb.charAt(i));
            }
        }
        return sb.toString();
    }

}
