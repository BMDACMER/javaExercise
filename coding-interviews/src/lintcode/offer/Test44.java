package lintcode.offer;
// 24. ·´×ªÁ´±í
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


}
