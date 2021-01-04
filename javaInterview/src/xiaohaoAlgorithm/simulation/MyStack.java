package xiaohaoAlgorithm.simulation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 14:56
 * ʹ�ö���ʵ��ջ�����в�����
 * ����˼�룺
 * �������� ģ���ջ��ʱ�� ��ջ�е�Ԫ�س������һ��Ԫ�ز����� �����Ķ�����
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
            throw new Exception("ջΪ�� ���ܳ�ջ��");
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

       return 0; // �쳣����
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
