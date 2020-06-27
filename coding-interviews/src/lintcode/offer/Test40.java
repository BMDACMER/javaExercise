package lintcode.offer;

/// ��ʾ��ֵ���ַ���

/**
 * [] �� �ַ�����
 * () �� ����
 * ? �� �ظ� 0 ~ 1
 * + �� �ظ� 1 ~ n
 * * �� �ظ� 0 ~ n
 * . �� �����ַ�
 * \\. �� ת���� .
 * \\d �� ����
 */
public class Test40 {
    public boolean isNumeric(char[] str) {
        if (str == null)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
