package lintcode;


import java.util.Stack;

/**
 * 155. ��Сջ
 * ���һ��֧�� push ��pop ��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
 *
 * push(x) ���� ��Ԫ�� x ����ջ�С�
 * pop() ���� ɾ��ջ����Ԫ�ء�
 * top() ���� ��ȡջ��Ԫ�ء�
 * getMin() ���� ����ջ�е���СԪ�ء�
 */
public class Test155 {
    // ����ջ
    private Stack<Integer> data;
    // ����ջ
    private Stack<Integer> helper;

    /** initialize your data structure here. */
//    public MinStack() {
//        data = new Stack<>();
//        helper = new Stack<>();
//    }

    public void push(int x) {
        // ����ջ�͸���ջһ��������Ԫ��
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }


    public void pop() {
        // ����ջ��pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("ջ��Ԫ��Ϊ�գ��˲����Ƿ�");
    }
}
