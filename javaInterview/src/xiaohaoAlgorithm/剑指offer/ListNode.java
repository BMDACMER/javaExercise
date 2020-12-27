package xiaohaoAlgorithm.½£Ö¸offer;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/27 11:12
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode head) {
        this.val = val;
        this.next = head;
    }
}

