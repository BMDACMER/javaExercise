package guohaoAlgorithm.剑指offer;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/3 12:00
 *
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class MinStack {

    Stack<Integer> data;   // 用来存储数据的  主栈
    Stack<Integer> help;   // 用来辅助   主要操作 getMin   用于返回最小值   从栈顶到栈底升序

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        help = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (help.isEmpty() || help.peek() >= x) {
            help.add(x);
        } else {
            help.add(help.peek());   // 若大于存储的  就存最小的
        }
    }

    public void pop() {
        data.pop();
        help.pop();
    }

    public int top() {
        if (!data.isEmpty())
            return data.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int min() {
        if (!help.isEmpty())
            return help.peek();
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
