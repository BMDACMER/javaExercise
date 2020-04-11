package codeguiide;

import java.util.Stack;

/**
 * ��дһ���࣬������ջʵ�ֶ��У�֧�ֶ��еĻ���������add, poll, peek��
 *
 * ע�⣺stackPush��stackPop���������������㣺
 * 1������һ���Խ�stackPush�е�����ѹ��ջ�� while
 * 2������ʱstackPop����Ϊ��
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
                // ��stackpushջ�е�Ԫ��ȫ��ѹ��ȥ
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
