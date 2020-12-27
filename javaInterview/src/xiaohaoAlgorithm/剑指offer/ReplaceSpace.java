package xiaohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/27 10:49
 */
public class ReplaceSpace {
    // ����һ��������������
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            } else {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }
        }
        return sb.toString();
    }

    // ��������ԭ���޸�
    // �ο���https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50c26h/


    public static void main(String[] args) {
        ReplaceSpace r = new ReplaceSpace();
        String s = r.replaceSpace("We are happy.");
        for (char c : s.toCharArray())
            System.out.print(c);
    }
}
