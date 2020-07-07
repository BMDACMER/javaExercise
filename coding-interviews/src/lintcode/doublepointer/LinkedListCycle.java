package lintcode.doublepointer;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/7 7:19
 *
 * 141. ��������
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // ����ָ�룬������ڻ� ��ô��ָ�������
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
