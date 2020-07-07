package lintcode.doublepointer;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/7 7:19
 *
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // 两个指针，如果存在环 那么两指针必相遇
        ListNode node1 = head;
        ListNode node2 = head;
        while (node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
            if (node2 != null) {
                node2 = node2.next;
                if (node1 != null & node2 != null && node1 == node2)
                    return true;
            } else if (node2 == null) {
                return false;
            }

        }
        return false;
    }
}
