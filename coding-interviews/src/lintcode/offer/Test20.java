package lintcode.offer;

/**
 * �滻�ո�
 * ˼·�����ַ����洢������ԭ�ַ����ĳ���length�ͺͰ����Ŀո���n������Լ�����µ��ַ���
 * ����Ϊlength + 2n. �Ӻ���ǰ�ƶ�ÿ�������ո����%20�滻�����η����µ��ַ����С�
 */
public class Test20 {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() < 1)
            return "";
        // ͳ���ַ����пո���
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        StringBuffer newStr = new StringBuffer(str.length() + 2 * count);
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {   // �滻
                newStr.append('0');
                newStr.append('2');
                newStr.append('%');
            } else {
                newStr.append(str.charAt(i));   // ֱ�ӷ���
            }
        }
        return newStr.reverse().toString();
    }
}
