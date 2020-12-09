package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/9 10:51
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode head) {
        this.val = val;
        this.next = head;
    }
}
