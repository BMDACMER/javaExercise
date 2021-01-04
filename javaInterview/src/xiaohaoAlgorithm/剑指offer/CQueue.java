package xiaohaoAlgorithm.½£Ö¸offer;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 19:19
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
       if (stack2.isEmpty()) {
           if (stack1.isEmpty()) return -1;
           while (!stack1.isEmpty())
               stack2.push(stack1.pop());
       }
        return stack2.pop();
    }
}
