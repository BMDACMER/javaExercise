package guohaoAlgorithm.oneQuestionPerDay;

import java.util.Stack;

/**
 * @Author guohao
 * @Date 2021/3/5 10:09
 * @Version 1.0
 *
 * 232. ��ջʵ�ֶ���
 * �����ʹ������ջʵ�������ȳ����С�����Ӧ��֧��һ����е�֧�ֵ����в�����push��pop��peek��empty����
 *
 * ʵ�� MyQueue �ࣺ
 *
 * void push(int x) ��Ԫ�� x �Ƶ����е�ĩβ
 * int pop() �Ӷ��еĿ�ͷ�Ƴ�������Ԫ��
 * int peek() ���ض��п�ͷ��Ԫ��
 * boolean empty() �������Ϊ�գ����� true �����򣬷��� false
 *
 *
 * ˵����
 *
 * ��ֻ��ʹ�ñ�׼��ջ���� ���� Ҳ����ֻ�� push to top, peek/pop from top, size, �� is empty �����ǺϷ��ġ�
 * ����ʹ�õ�����Ҳ��֧��ջ�������ʹ�� list ���� deque��˫�˶��У���ģ��һ��ջ��ֻҪ�Ǳ�׼��ջ�������ɡ�
 */
public class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1; // ��ջ
    Stack<Integer> stack2;   // ��ջ
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
