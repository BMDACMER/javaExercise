package xiaohaoAlgorithm.stack;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/6 17:24
 *
 * 20. ÓÐÐ§µÄÀ¨ºÅ
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && lenOf(c) == stack.peek())
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private char lenOf(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '{';
    }
}
