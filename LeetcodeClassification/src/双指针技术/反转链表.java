package ˫ָ�뼼��;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/2 13:55
 * 206  ��ת����
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ��ת���� {
    // �ݹ�  �Ƚϳ���
    // �ο���http://www.cnblogs.com/cdf-opensource-007/p/13246922.html
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next);
        next.next = head;
//        head.next = null;
        return newHead;
    }

    // ������  ֱ�������
    public ListNode ReverseList2(ListNode head) {
        ListNode newList = new ListNode(-1,null);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    // �������
    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ��ת���� m = new ��ת����();
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        m.ReverseList(listNode1);
        m.printList(listNode4);
    }
}


