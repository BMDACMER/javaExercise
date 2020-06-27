package lintcode.offer;
// 19  ���t���_ʽƥ��

/**
 * https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c?answerType=1&f=discussion
 */
public class Test39 {
    public boolean match(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }

    private boolean matchStr(char[] str, int i, char[] pattern, int j) {
        // �߽�
        if (str.length == i && pattern.length == j) // ��ȫƥ��
            return true;
        else if (pattern.length == j)                // ģʽ��Ϊ�գ��ַ�����Ϊ�գ�ƥ��ʧ��
            return false;
        // �ж���һ���ַ��Ƿ�Ϊ'*'
        boolean next = (j + 1 < pattern.length) && (pattern[j+1] == '*');  // ģʽ������һ���Ƿ�Ϊ*
        if (next) {
            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i])) {   // * ƥ���Ϊ 0��
                return matchStr(str,i,pattern,j+2) || matchStr(str,i+1,pattern,j);
            } else {
                return matchStr(str,i,pattern,j+2);
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || pattern[j] == str[i])) {
                return matchStr(str,i+1, pattern,j+1);
            } else {
                return false;
            }
        }
    }
}
