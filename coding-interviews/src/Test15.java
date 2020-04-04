/**
 * ����һ��������ת��������������ı�ͷ��
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
         * �� currentNextΪ��ʱ����current���  ��Ϊ��ǰ��תͷ���
         */
        ListNode current = head;   // ָ��ǰ���
        ListNode currentNext = current.next;   // ָ����һ���ڵ�
        while (currentNext != null) {
            ListNode currentNext2 = currentNext.next;   // ���ڱ�����һ���ڵ�
            currentNext.next = current;
            current = currentNext;
            currentNext = currentNext2;
        }
        head.next = null;   // ���ӻ�������ѭ��
        return current;
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

        System.out.println(ReverseList(head).val);
    }
}
