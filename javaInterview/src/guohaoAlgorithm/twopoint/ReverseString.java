package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 11:20
 *
 * 344. ��ת�ַ���
 */
public class ReverseString {

    // ����˫ָ�뷽��
    public void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1) return;

        char ch;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
        return;
    }
}
