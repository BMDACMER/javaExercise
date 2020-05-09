package lintcode.offer;

/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 */
public class Test17 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        // 第一个结点就是要删除的
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        ListNode pPre = head;
        while ( p != null && p.val != val) {
            pPre = p;
            p = p.next;
        }
        // 遍历完 也没有找到val
        if (p == null) {
            return head;   // 未找到
        }
        pPre.next = p.next;

        return head;
    }

}

