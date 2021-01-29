package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 15:05
 * 61. ��ת����
 */
public class RotateRight2 {

    // ������תΪѭ������  ������k%n����λ
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        // �γɻ�
        ListNode cur = head;
        int n = 1; // ͳ��������
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
