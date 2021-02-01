package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 10:11
 *
 * ��ת��������
 */
public class Reverse {
    // �ݹ� Recursion
    public ListNode reverseRecursion(ListNode head) {
        // ������Ϊ�ջ�ֻ��һ���ڵ�ʱ  ֱ�ӷ���
        if (head == null || head.next == null) return head;

        ListNode last = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // �ǵݹ�UnRecursion
    public ListNode reverseRecursion2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    // ��תǰn���ڵ�
    // recursion
    // �����ڵ�
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // ��¼��n+1���ڵ㣬����ʹ��
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    // UnRecursion  �Լ���ͼд��
    public ListNode reverseNUnRecursion(ListNode head, int n) {
        ListNode cur = head, pre, end = head;
        for (int i = 0; i < n; i++) {
            if (end == null) break;
            end = end.next;
        }
        pre = end == null ? null : end.next;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // ��ת����[m,n]֮��Ľڵ�     m��1��ʼ  ˼·����תΪ��תǰn���ڵ�
    // Recursion
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    // K ��һ�鷴ת  hard�Ѷ�
    ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head, pre = null;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }

        // ��תǰK��Ԫ��
        ListNode newHead = reverseAB(a, b);
        // �ݹ鷴ת����������������
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // ��ת �ڵ�a-->b֮��Ľڵ�
    ListNode reverseAB(ListNode a, ListNode b) {
        ListNode cur = a, pre = null;
        while (cur != b) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /// ����������
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Reverse r = new Reverse();

//        ListNode res = r.reverseNUnRecursion(head, 3);
//        ListNode res = r.reverseBetween(head, 2,4);
        ListNode res = r.reverseKGroup(head, 2);

        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }
}
