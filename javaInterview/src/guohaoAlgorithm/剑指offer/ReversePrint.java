package guohaoAlgorithm.剑指offer;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/1 10:05
 *
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint {

    // 反转链表
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
