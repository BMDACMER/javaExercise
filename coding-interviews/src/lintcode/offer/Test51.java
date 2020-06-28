package lintcode.offer;

import java.util.Stack;

// https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106?f=discussion
// 引入辅助栈
public class Test51 {

    Stack<Integer> stack = new Stack<>();   // 引入辅助栈

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length)
            return false;
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (popIndex < popA.length && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}
