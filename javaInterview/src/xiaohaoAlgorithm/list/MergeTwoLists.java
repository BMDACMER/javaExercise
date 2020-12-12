package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/12 13:03
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {

    /**
     * 归并排序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0,null);
        ListNode res = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

      /*  while (l1 != null) {
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }

        while (l2 != null) {
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }*/

        res.next = l1 == null ? l2 : l1;

        return ans.next;
    }
}
