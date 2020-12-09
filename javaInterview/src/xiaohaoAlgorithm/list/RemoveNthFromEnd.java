package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/9 11:00
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    // 快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建带头节点的单链表
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
