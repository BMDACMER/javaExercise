package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 14:30
 *
 * 面试题 02.02. 返回倒数第 k 个节点
 *
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class KthToLast {

    // 与getKthFromEnd类似
    public int kthToLast(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
