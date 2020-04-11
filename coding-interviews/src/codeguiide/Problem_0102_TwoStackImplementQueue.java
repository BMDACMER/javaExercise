package codeguiide;

import java.util.Stack;

/**
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add, poll, peek）
 *
 * 注意：stackPush和stackPop必须满足以下两点：
 * 1）必须一次性将stackPush中的数据压入栈中 while
 * 2）弹出时stackPop必须为空
 */
public class Problem_0102_TwoStackImplementQueue {
    public static class TwoStacksQueue {
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void add(int newNum) {
            stackPush.push(newNum);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.isEmpty()) {
                // 将stackpush栈中的元素全部压进去
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

    }


    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
