/**
 * ����һ����������������е�����k����㡣
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
        int length = 0;  // ����ĳ���
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        // ������k�� ��������length-k+1��
        int count = 0;  // ��������Ƿ��ҵ�������k����
        p = head; // ����ָ��head
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
        ListNode tail = head;  // β�巨   �࿪��һ��ָ��
        for (int i = 2; i < 5; i++) {
            ListNode x = new ListNode(i);
            x.next = null;
            tail.next = x;
            tail = x;
        }

        System.out.println(FindKthToTail(head, 1).val);
    }

}
