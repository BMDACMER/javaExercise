package lintcode.offer;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 */
public class Test06 {
//    public CQueue() {
//
//    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
       if (stack2.isEmpty()) {
           if (stack1.isEmpty()) return -1;
           while (!stack1.isEmpty()){
               stack2.push(stack1.pop());
           }
       }
        return stack2.pop();
    }
}
