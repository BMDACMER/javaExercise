package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 10:11
 *
 * 反转整条链表
 */
public class Reverse {
    // 递归 Recursion
    public ListNode reverseRecursion(ListNode head) {
        // 当链表为空或只有一个节点时  直接返回
        if (head == null || head.next == null) return head;

        ListNode last = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 非递归UnRecursion
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


    // 反转前n个节点
    // recursion
    // 后驱节点
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第n+1个节点，后面使用
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    // UnRecursion  自己画图写的
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

    // 反转区间[m,n]之间的节点     m从1开始  思路就是转为反转前n个节点
    // Recursion
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    // K 个一组反转  hard难度
    ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head, pre = null;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }

        // 反转前K个元素
        ListNode newHead = reverseAB(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转 节点a-->b之间的节点
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


    /// 测试主函数
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
