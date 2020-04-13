package codeguiide;

import com.sun.javafx.image.impl.IntArgb;

import java.util.Stack;

//栈排序
public class Problem_0105_StackSortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStackByStack(stack);
        print(stack);
    }

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            while (!help.isEmpty() && help.peek() < current) {
                stack.push(help.pop());
            }
            help.push(current);
        }
        // 最后将help逐一压入栈中
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void print(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
