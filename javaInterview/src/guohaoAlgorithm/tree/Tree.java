package guohaoAlgorithm.tree;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/18 10:25
 *
 *
 * 记录树的各个遍历 操作
 */
public class Tree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) return;

        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void postOrderRecur(Node head) {
        if (head == null) return;

        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    // unrecursive
    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.value + " ");
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
    }

    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }

        System.out.println();
    }

    public static void postOrderUnRecur(Node head) {
        System.out.print("post-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.left.left = new Node(2);
        head.left.left.left = new Node(1);
        head.left.right = new Node(4);
        head.right = new Node(8);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.right = new Node(11);
        head.right.right.left = new Node(9);

        // 递归 recursive
        System.out.println("====================recursive===================");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("post-order: ");
        postOrderRecur(head);
        System.out.println();

        // 非递归 un-recursive
        System.out.println("==================un-recursive=================");
        System.out.print("pre-order: ");
        preOrderUnRecur(head);
        System.out.println();
        inOrderUnRecur(head);
        postOrderUnRecur(head);
        System.out.println();
    }
}
