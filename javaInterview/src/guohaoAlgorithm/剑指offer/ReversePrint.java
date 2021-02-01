package guohaoAlgorithm.��ָoffer;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 10:05
 *
 * ��ָ Offer 06. ��β��ͷ��ӡ����
 * ����һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺head = [1,3,2]
 * �����[2,3,1]
 */
public class ReversePrint {

    // ��ת����
    public int[] reversePrint(ListNode head) {
//        ListNode newHead = reverse(head);
        ListNode newHead = unReverse(head);
        ArrayList<Integer> arr = new ArrayList<>();
        while (newHead != null) {
            arr.add(newHead.val);
            newHead = newHead.next;
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    // UnRecursion
    private ListNode unReverse(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    // recursion
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }



}
