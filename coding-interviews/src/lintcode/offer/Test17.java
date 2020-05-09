package lintcode.offer;

/**
 * ������18. ɾ������Ľڵ�
 * �������������ͷָ���һ��Ҫɾ���Ľڵ��ֵ������һ������ɾ���ýڵ㡣
 * <p>
 * ����ɾ����������ͷ�ڵ㡣
 * <p>
 * ע�⣺����Ա�ԭ���иĶ�
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
        // ��һ��������Ҫɾ����
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        ListNode pPre = head;
        while ( p != null && p.val != val) {
            pPre = p;
            p = p.next;
        }
        // ������ Ҳû���ҵ�val
        if (p == null) {
            return head;   // δ�ҵ�
        }
        pPre.next = p.next;

        return head;
    }

}

