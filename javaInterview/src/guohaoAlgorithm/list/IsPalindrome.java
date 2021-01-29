package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 9:54
 *
 * 234. ��������
 * ���ж�һ�������Ƿ�Ϊ��������
 *
 * ʾ�� 1:
 *
 * ����: 1->2
 * ���: false
 * ʾ�� 2:
 *
 * ����: 1->2->2->1
 * ���: true
 */
public class IsPalindrome {

    // ����ָ��    ��������ż������
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // �������������  ����������ƶ�һ��
        if (fast != null) slow = slow.next;
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) return false;
            right = right.next;
            left = left.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
