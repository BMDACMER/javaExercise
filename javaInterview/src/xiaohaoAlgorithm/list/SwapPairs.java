package xiaohaoAlgorithm.list;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 15:39
 * <p>
 * 24. �������������еĽڵ�
 */
public class SwapPairs {
    // ÿ������תһ��
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head, prev = new ListNode(-1);
        Stack<ListNode> stack = new Stack<>();
        head = prev;
        while (curr != null && curr.next != null) {
            stack.push(curr);
            stack.push(curr.next);

            curr = curr.next.next;

            prev.next = stack.pop();
            prev = prev.next;
            prev.next = stack.pop();
            prev = prev.next;
        }
        prev.next = curr;

        return head.next;
    }

    // �ݹ�
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
