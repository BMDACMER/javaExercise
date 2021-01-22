package guohaoAlgorithm.twopoint;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 14:24
 *
 * ��ָ Offer 22. �����е�����k���ڵ�
 */
public class GetKthFromEnd {

    // ����ָ��
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow, fast;
        slow = fast = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
