package lintcode.offer;

import java.util.ArrayList;

public class Test21HeadInsertion {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 头插法
        ListNode head = new ListNode(-1);  // 创建头结点
        while (listNode != null) {
            ListNode memo = listNode.next;   // 保存listNode的下一个节点
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }

        // 逆序
        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;   // 去掉掉-1的头结点
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
