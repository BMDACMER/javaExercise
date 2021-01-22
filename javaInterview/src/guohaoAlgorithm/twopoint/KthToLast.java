package guohaoAlgorithm.twopoint;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 14:30
 *
 * ������ 02.02. ���ص����� k ���ڵ�
 *
 * ��ָ Offer 22. �����е�����k���ڵ�
 */
public class KthToLast {

    // ��getKthFromEnd����
    public int kthToLast(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
