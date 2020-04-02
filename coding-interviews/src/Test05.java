import java.util.Stack;

/**
 *��Ŀ������������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ��
 */
public class Test05 {

    /**
     * �ڵ����
     */
    public static class ListNode{
        int val;    // ����ֵ
        ListNode next;  // ��һ���ڵ�
    }

    /**
     * ����������ͷ��㣬��δ��ͷ��������ӡ��ÿ���ڵ��ֵ
     * ʹ��ջ�ķ�ʽ����
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
     * ����������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
     * ʹ��ջ�ķ�ʽ����
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
