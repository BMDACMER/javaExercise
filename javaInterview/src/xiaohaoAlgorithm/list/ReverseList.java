package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/23 15:10
 *
 * 剑指 Offer 24. 反转链表
 *
 * 参考：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/jian-zhi-offer-24-fan-zhuan-lian-biao-die-dai-di-2/
 */
public class ReverseList {
    // 递归
    public ListNode reverseList(ListNode head) {
        return recur(head, null);   // 调用递归并返回
    }

    private ListNode recur(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode res = recur(curr.next, curr);
        curr.next = prev;
        return res;
    }

    // 迭代
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
