package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 15:10
 *
 * ��ָ Offer 24. ��ת����
 *
 * �ο���https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/jian-zhi-offer-24-fan-zhuan-lian-biao-die-dai-di-2/
 */
public class ReverseList {
    // �ݹ�
    public ListNode reverseList(ListNode head) {
        return recur(head, null);   // ���õݹ鲢����
    }

    private ListNode recur(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode res = recur(curr.next, curr);
        curr.next = prev;
        return res;
    }

    // ����
    public ListNode reverseList2(ListNode head) {
        ListNode curr = head, prev = null, temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
