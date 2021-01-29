package guohaoAlgorithm.list;

import guohaoAlgorithm.tree.Tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 15:24
 *
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenList {

    // 自己做的   一遍过 花了40分钟   害
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        // 以下链表的长度至少为2
        ListNode second = head.next;
        ListNode headFirst = head, headSecond = second;
        boolean flag = true;
        while (headFirst.next != null && headSecond.next != null) {
            if (flag) {
                headFirst.next = headFirst.next.next;
                headFirst = headFirst.next;
                flag = false;
            }else {
                headSecond.next = headSecond.next.next;
                headSecond = headSecond.next;
                flag = true;
            }
        }
        headFirst.next = second;
        headSecond.next = null;

        return head;
    }
}
