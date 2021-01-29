package guohaoAlgorithm.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 12:39
 *
 * 148. ��������
 * ���������ͷ��� head ���뽫�䰴 ���� ���в����� ���������� ��
 *
 * ���ף�
 *
 * ������� O(n log n) ʱ�临�ӶȺͳ������ռ临�Ӷ��£����������������
 *
 * ���룺head = [4,2,1,3]
 * �����[1,2,3,4]
 */
public class SortList {

    // �����㷨
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        ArrayList<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        Collections.sort(arr, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < arr.size(); i++) {
            cur.next = new ListNode(arr.get(i).val);
            cur = cur.next;
        }
        return dummy.next;
    }

    // ���ȶ���
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList2(head);
        ListNode right = sortList2(temp);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }

    public static void main(String[] args) {
        SortList test = new SortList();
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = test.sortList2(head);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}
