package lintcode;


import java.util.Stack;

/**
 * 20. ��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
 */
public class Test20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<Character>();
        for (Character c:s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
