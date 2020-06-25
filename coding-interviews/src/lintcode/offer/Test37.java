package lintcode.offer;
// �� O(1) ʱ����ɾ������ڵ�
public class Test37 {

    public ListNode deleteNode(ListNode head, int val) {
        // ɾ����һ����㣬�������ڵ�
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode pre = tmp;
        ListNode current = tmp.next;
        // �ҵ�val���
        while (current != null && current.val != val) {
            pre = current;
            current = current.next;
        }

        // �ҵ��˻����ߵ�ͷ��
        if (current != null) {
            pre.next = current.next;   // ɾ���ýڵ�
        }
        return tmp.next;
    }

}
