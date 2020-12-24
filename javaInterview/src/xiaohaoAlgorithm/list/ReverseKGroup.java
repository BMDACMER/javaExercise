package xiaohaoAlgorithm.list;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 16:34
 * 25. K ��һ�鷭ת����
 *
 * Ч�ʱȽϵ�
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
                // ˵��û������  ����Ҫ��ת   ֱ�Ӹ��ƹ�ȥ����
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
     * �ݹ�˼��  ��תk������
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        // ��ת����[a,b)�ϵ�Ԫ��
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // ����k������Ҫ��ת�� base case
            if (b == null) return head;
            b = b.next;
        }
        // ��תǰk��Ԫ��
        ListNode newHead = reverse(a,b);
        // �ݹ鷴ת����������������
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
