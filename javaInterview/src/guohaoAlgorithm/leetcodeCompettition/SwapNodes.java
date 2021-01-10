package guohaoAlgorithm.leetcodeCompettition;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 11:19
 *
 * 5652. 交换链表中的节点
 */
public class SwapNodes {

    /*public ListNode swapNodes(ListNode head, int k) {
        int fast = 1, slow = 1, len = 0;
        ListNode p = head, pre = p, pLen = head;
        // 统计链表长度
        while (pLen != null) {
            pLen = pLen.next;
            len++;
        }

        while (p != null && fast != k) {
            fast++;
            pre = p;
            p = p.next;
        }
        ListNode node1 = new ListNode(pre.val);

        int kk = len - fast;
        while (p!=null && slow != kk) {
            slow++;
            pre = p;
            p = p.next;
        }
        ListNode node2 = new ListNode(pre.val);


        ///
        ListNode dummy=new ListNode(0);
        ListNode curr = dummy, p3 = head;
        while (p3 != null) {
            if (p3 == node2) {
                curr.next = new ListNode(node1.val);
            } else if (p3 == node1) {
                curr.next = new ListNode(node2.val);
            } else {
                curr.next = new ListNode(p3.val);
            }

            curr = curr.next;
            p3 = p3.next;
        }


        return dummy.next;
    }*/

    public ListNode swapNodes(ListNode head, int k) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        // 分别找到要交换的两个节点
        int first = 0, second = len - k +1;
        ListNode pFirst = head, pSecond = head, pre = null;
        while (pFirst != null && first != k) {
            first++;
            pre = pFirst;
            pFirst = pFirst.next;
        }
        ListNode node1 = new ListNode(pre.val);
        first = 0;
        while (pSecond != null && first != second) {
            first++;
            pre = pSecond;
            pSecond = pSecond.next;
        }
        ListNode node2 = new ListNode(pre.val);

        // 创建新链表
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy, h = head;
        int index = 1;
        while (h != null) {
            if (index == k) {
                cur.next = new ListNode(node2.val);
            } else if (index == second) {
                cur.next = new ListNode(node1.val);
            } else {
                cur.next = new ListNode(h.val);
            }
            index++;
            cur = cur.next;
            h = h.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SwapNodes s = new SwapNodes();
        ListNode node = s.swapNodes(node1, 2);

        // 打印listnode
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
