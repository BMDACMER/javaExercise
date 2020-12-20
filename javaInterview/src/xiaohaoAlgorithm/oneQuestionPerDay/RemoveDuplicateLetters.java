package xiaohaoAlgorithm.oneQuestionPerDay;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/20 10:32
 *
 * 316. ȥ���ظ���ĸ
 */
public class RemoveDuplicateLetters {

    /**
     * 1����Ҫ����ջ����Ϊ���������ݽṹ
     * 2����Ҫ��¼ÿһ���ַ����һ�γ��ֵ��ַ�
     * 3���жϵ�ǰ��������ĸ��ջ���Ƿ��Ѿ�����
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int len = s.length();

        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<Character>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a'])
                continue;
            // ��ջ��Ϊ����Ҫװ�����ַ���ջ��Ԫ�ش���ջ��Ԫ�غ����������
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }

            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
