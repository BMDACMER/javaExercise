package codeguiide;

import java.util.Scanner;
import java.util.Stack;

/**
 *  ���һ����getMin���ܵ�ջ
 *
 *  ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ�ַ���ջ����СԪ�صĲ���
 *  Ҫ��
 *  1��pop��push��getMin������ʱ�临�Ӷȶ���O��1��
 *  2����Ƶ�ջ���Ϳ���ʹ���ֳɵ�ջ�ṹ
 *
 */
public class Problem_0101_GetMinStack {

    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<>();
        }

        // ����ڵڶ��ַ���  ��ջ��ʡʱ��
        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            }
            if (newNum <= stackMin.peek()) {
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            int value = stackData.pop();
            if (value == stackMin.peek()) {
                stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return stackMin.peek();
        }
    }


    public static class MyStack2{
        Stack<Integer> stackData;
        Stack<Integer> stackMin;

        public MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty() || newNum < getMin()) {
                stackMin.push(newNum);
            } else{
                stackMin.push(stackMin.peek());
            }
            stackData.push(newNum);
        }

        // ����ڵ�һ�ַ��� ��ջ��ʡʱ��
        public int pop() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());  // 3
        stack1.push(4);
        System.out.println(stack1.getMin());  // 3
        stack1.push(1);
        System.out.println(stack1.getMin());  // 1
        System.out.println(stack1.pop());  // 1
        System.out.println(stack1.getMin());  // 3

        System.out.println("**********************************");

        MyStack1 stack2 = new MyStack1();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());

    }
}
