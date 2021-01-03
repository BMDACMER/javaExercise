package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 9:07
 *
 * 86. 分隔链表
 */
public class Partition {

    /**
     * 思路：
     *  1）将小于x的值在原链表中直接修改指针，用带头节点的listLeft串起来
     *  2）将大于等于x的值存在带头节点的listRight链表中
     *  3）将listRight链表合并到listLeft中即可
     *  4）返回listLeft.next即可（因为listLeft指向的是头结点的，需返回下一节点）
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode listLeft = new ListNode(-1), left = listLeft;  // 带头节点的 小于x值的左分支
        ListNode listRight = new ListNode(-1), right = listRight;  // 带头节点的 大于等于x值的右分支

        while (head != null) {
            if (head.val >= x) {
                // 这里得单独建立一个分支
                right.next = new ListNode(head.val);
                right = right.next;
            } else {
                // 这里只需要在原链表中更改指针即可
                left.next = head;
                left = left.next;
            }
            head = head.next;
        }

        // 将listRight合并到listLeft中
        while (listRight.next != null) {
            left.next = listRight.next;
            left = left.next;
            listRight = listRight.next;
        }

        return listLeft.next;
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;*/

        ListNode node1 = new ListNode(1);

        Partition p = new Partition();
        ListNode result = p.partition(node1, 0);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
