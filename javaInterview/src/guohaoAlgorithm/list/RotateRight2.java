package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 15:05
 * 61. 旋转链表
 */
public class RotateRight2 {

    // 将链表转为循环链表  在右移k%n个单位
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // 形成环
        ListNode cur = head;
        int n = 1; // 统计链表长度
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        if (k % n == 0) return head;
        cur.next = head;

        //
        k = k % n;
        ListNode newHead = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newHead = newHead.next;
        }
        ListNode res = newHead.next;
        newHead.next = null;
        return res;
    }
}
