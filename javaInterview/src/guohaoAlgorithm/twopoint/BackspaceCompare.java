package guohaoAlgorithm.twopoint;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 13:06
 *
 * 844. 比较含退格的字符串
 */
public class BackspaceCompare {

    // 采用栈
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (stack1.isEmpty()) continue;
                stack1.pop();
            } else {
                stack1.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (stack2.isEmpty()) continue;
                stack2.pop();
            } else {
                stack2.push(c);
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        BackspaceCompare b = new BackspaceCompare();
        System.out.println(b.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
