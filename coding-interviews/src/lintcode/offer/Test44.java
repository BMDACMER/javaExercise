package lintcode.offer;
// 24. ��ת����
public class Test44 {
    public ListNode ReverseList(ListNode head) {
        ListNode reverseHead = new ListNode(0);
        while (head != null) {
            ListNode p = head.next;
            head.next = reverseHead.next;
            reverseHead.next = head;
            head = p;
        }

        return reverseHead.next;
    }

    // �ݹ����
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newList = ReverseList2(head.next);
        ListNode t = head.next;
        t.next = head;
        head.next = null;
        return newList;
    }



}
