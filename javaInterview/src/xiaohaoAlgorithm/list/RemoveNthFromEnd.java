package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/9 11:00
 * 19. ɾ������ĵ�����N���ڵ�
 */
public class RemoveNthFromEnd {
    // ����ָ��
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ������ͷ�ڵ�ĵ�����
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head, slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
