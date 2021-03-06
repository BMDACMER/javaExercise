package xiaohaoAlgorithm.list;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 16:34
 * 25. K 个一组翻转链表
 *
 * 效率比较低
 */
public class ReverseKGroup {

    /*public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        int n;
        ListNode curr = head;
        ListNode prev = new ListNode(-1);
        head = prev;

        while (curr != null) {
            n = k;
            while (curr != null && n > 0) {
                stack.push(curr);
                curr = curr.next;
                n--;
            }

            if (n != 0) {
                // 说明没有整除  不需要翻转   直接复制过去即可
                Stack<ListNode> stack2 = new Stack<>();
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
                while (!stack2.isEmpty()) {
                    prev.next = stack2.pop();
                    prev = prev.next;
                }

            } else {
                while (!stack.isEmpty()) {
                    prev.next = stack.pop();
                    prev = prev.next;
                }
            }

        }
        prev.next = curr;

        return head.next;
    }*/

    /**
     * 递归思想  反转k个数组
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        // 反转区间[a,b)上的元素
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 不足k个不需要反转， base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前k个元素
        ListNode newHead = reverse(a,b);
        // 递归反转后续链表并链接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode curr = a, tmp, prev = null;
        while (curr != b) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = prev;
        }
        return prev;
    }
}
