package guohaoAlgorithm.twopoint;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 14:24
 *
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {

    // 快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow, fast;
        slow = fast = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
