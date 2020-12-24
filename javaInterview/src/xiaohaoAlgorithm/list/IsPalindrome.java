package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/24 10:17
 *
 * 234. ��������
 */
public class IsPalindrome {

    /**
     * �ݹ�
     */
    /*ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean traverse = traverse(right.next);
        traverse = traverse && (left.val == right.val);
        left = left.next;
        return traverse;
    }*/

    /**
     * ˫ָ��  fast  slow
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ˵��������ĳ���Ϊ����  slow��Ҫ�����ƶ�һ��
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // ������������
    private ListNode reverse(ListNode head) {
        ListNode curr = head, temp, prev = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
