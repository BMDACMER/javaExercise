package lintcode.offer;
// 在 O(1) 时间内删除链表节点
public class Test37 {

    public ListNode deleteNode(ListNode head, int val) {
        // 删除下一个结点，添加虚拟节点
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode pre = tmp;
        ListNode current = tmp.next;
        // 找到val结点
        while (current != null && current.val != val) {
            pre = current;
            current = current.next;
        }

        // 找到了或者走到头了
        if (current != null) {
            pre.next = current.next;   // 删除该节点
        }
        return tmp.next;
    }

}
