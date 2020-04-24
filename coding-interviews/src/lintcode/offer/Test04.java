package lintcode.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ������06. ��β��ͷ��ӡ����
 * <p>
 * ����һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
 */
public class Test04 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head;
        int count = 0;
        while (p!=null) {
            count++;
            p = p.next;
        }
        int[] arr = new int[count];
        p = head;
        for (int i = count - 1; i >= 0; i--) {
            arr[i] = p.val;
            p = p.next;
        }
        return arr;
    }
}
