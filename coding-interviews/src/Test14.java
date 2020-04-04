/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Test14 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        int length = 0;  // 链表的长度
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        // 倒数第k个 即正数第length-k+1个
        int count = 0;  // 用来标记是否找到倒数第k个数
        p = head; // 重新指向head
        while (p != null) {
            count++;
            if (count == length - k + 1) {
                return p;
            }
            p = p.next;
        }
        return p;
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

        System.out.println(FindKthToTail(head, 1).val);
    }

}
