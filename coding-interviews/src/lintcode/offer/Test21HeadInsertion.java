package lintcode.offer;

import java.util.ArrayList;

public class Test21HeadInsertion {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // ͷ�巨
        ListNode head = new ListNode(-1);  // ����ͷ���
        while (listNode != null) {
            ListNode memo = listNode.next;   // ����listNode����һ���ڵ�
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }

        // ����
        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;   // ȥ����-1��ͷ���
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
