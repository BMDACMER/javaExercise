package lintcode.offer;


import java.util.Stack;

public class Test50 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        if (!stack.isEmpty())
            stack.pop();
        if (!minStack.isEmpty())
            minStack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
