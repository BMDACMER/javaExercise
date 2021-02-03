package guohaoAlgorithm.��ָoffer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/3 11:56
 *
 * ��ָ Offer 24. ��ת����
 * ����һ������������һ�������ͷ�ڵ㣬��ת�����������ת�������ͷ�ڵ㡣
 *
 *
 *
 * ʾ��:
 *
 * ����: 1->2->3->4->5->NULL
 * ���: 5->4->3->2->1->NULL
 */
public class ReverseList {

    //recursion
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // unRecursion
    public ListNode reverseList2(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
