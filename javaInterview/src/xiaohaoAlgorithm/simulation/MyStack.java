package xiaohaoAlgorithm.simulation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 14:56
 * 使用队列实现栈的下列操作：
 * 基本思想：
 * 两个队列 模拟出栈的时候 将栈中的元素除了最后一个元素不出外 其他的都出完
 */
public class MyStack {

    Deque<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q.size() == 0) try {
            throw new Exception("栈为空 不能出栈啦");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Deque<Integer> tmp = new LinkedList<>();
        while (q.size() > 1) {
            tmp.add(q.poll());
        }

        int val = q.poll();
        while (!tmp.isEmpty()) {
            q.add(tmp.poll());
        }

        return val;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!q.isEmpty()) {
            Deque<Integer> tmp = new LinkedList<>();
            while (q.size() > 1) {
                tmp.add(q.poll());
            }

            int val = q.poll();
            while (!tmp.isEmpty()) {
                q.add(tmp.poll());
            }
            q.add(val);
            return val;
        }

       return 0; // 异常处理
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }


    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + "   " + param_3 + "   " + param_4);
    }
}
