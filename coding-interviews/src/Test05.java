import java.util.Stack;

/**
 *题目：输入各链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class Test05 {

    /**
     * 节点对象
     */
    public static class ListNode{
        int val;    // 结点的值
        ListNode next;  // 下一个节点
    }

    /**
     * 输入个链表的头结点，从未到头反过来打印出每个节点的值
     * 使用栈的方式进行
     */
    public static void printListInverselyUsingIteration(ListNode root){
        Stack<ListNode> stack = new Stack<>();
        while (root != null){
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()){
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     */
    public static void printListInverselyUsingRecursion(ListNode root){
        if (root != null){
            printListInverselyUsingIteration(root.next);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

        printListInverselyUsingIteration(root);
        System.out.println("\n==============================");
        printListInverselyUsingRecursion(root);
    }

}
