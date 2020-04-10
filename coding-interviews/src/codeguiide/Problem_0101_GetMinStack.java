package codeguiide;

import java.util.Scanner;
import java.util.Stack;

/**
 *  设计一个有getMin功能的栈
 *
 *  实现一个特殊的栈，在实现栈的基本功能的基础上，在实现返回栈中最小元素的操作
 *  要求：
 *  1、pop、push、getMin操作的时间复杂度都是O（1）
 *  2、设计的栈类型可以使用现成的栈结构
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

        // 相比于第二种方法  进栈更省时间
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

        // 相比于第一种方法 出栈更省时间
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
