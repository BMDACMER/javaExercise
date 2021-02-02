package guohaoAlgorithm.��ָoffer;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/2 10:21
 *
 * ��ָ Offer 09. ������ջʵ�ֶ���
 * ������ջʵ��һ�����С����е��������£���ʵ�������������� appendTail �� deleteHead ���ֱ�����ڶ���β�������������ڶ���ͷ��ɾ�������Ĺ��ܡ�(��������û��Ԫ�أ�deleteHead �������� -1 )
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * �����[null,null,3,-1]
 * ʾ�� 2��
 *
 * ���룺
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * �����[null,-1,null,null,5,2]
 */
public class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // ��� ---> ��ջ
    public void appendTail(int value) {
        stack1.push(value);
    }

    // ����
    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
