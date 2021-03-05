package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Stack;

/**
 * @Author guohao
 * @Date 2021/3/5 10:09
 * @Version 1.0
 *
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1; // 进栈
    Stack<Integer> stack2;   // 出栈
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
