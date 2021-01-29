package guohaoAlgorithm.list;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 14:21
 *
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateRight {

    // 暴力算法
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ArrayList<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }

        int n = arr.size();
        k %= n;
        ListNode[] res = new ListNode[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr.get((i + n - k) % n);
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(res[i].val);
            cur = cur.next;
        }
        return dummy.next;
    }

}
