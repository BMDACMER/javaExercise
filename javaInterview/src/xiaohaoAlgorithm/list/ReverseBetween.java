package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/24 11:28
 *
 * 92. 反转链表 II
 */
public class ReverseBetween {

    // 后驱节点
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1) {
            return reverse(head, n);
        }

        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }

    public ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode next = reverse(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return next;
    }
}
