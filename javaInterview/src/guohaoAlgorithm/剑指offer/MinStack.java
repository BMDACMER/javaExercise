package guohaoAlgorithm.��ָoffer;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/3 12:00
 *
 * ��ָ Offer 30. ����min������ջ
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min �����ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
 *
 *
 *
 * ʾ��:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> ���� -3.
 * minStack.pop();
 * minStack.top();      --> ���� 0.
 * minStack.min();   --> ���� -2.
 */
public class MinStack {

    Stack<Integer> data;   // �����洢���ݵ�  ��ջ
    Stack<Integer> help;   // ��������   ��Ҫ���� getMin   ���ڷ�����Сֵ   ��ջ����ջ������

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
            help.add(help.peek());   // �����ڴ洢��  �ʹ���С��
        }
    }

    public void pop() {
        data.pop();
        help.pop();
    }

    public int top() {
        if (!data.isEmpty())
            return data.peek();
        throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
    }

    public int min() {
        if (!help.isEmpty())
            return help.peek();
        throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
    }
}
