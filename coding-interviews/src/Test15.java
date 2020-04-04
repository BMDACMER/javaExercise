/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Test15 {

    public static class ListNode {
       int val;
       ListNode next = null;

       ListNode(int val) {
           this.val = val;
       }
   }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        /**
         * 当 currentNext为空时返回current结点  即为当前逆转头结点
         */
        ListNode current = head;   // 指向当前结点
        ListNode currentNext = current.next;   // 指向下一个节点
        while (currentNext != null) {
            ListNode currentNext2 = currentNext.next;   // 用于保存下一个节点
            currentNext.next = current;
            current = currentNext;
            currentNext = currentNext2;
        }
        head.next = null;   // 不加会陷入死循环
        return current;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;  // 尾插法   多开辟一个指针
        for (int i = 2; i < 5; i++) {
            ListNode x = new ListNode(i);
            x.next = null;
            tail.next = x;
            tail = x;
        }

        System.out.println(ReverseList(head).val);
    }
}
