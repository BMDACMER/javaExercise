import java.util.HashMap;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Test56 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    HashMap<ListNode, Integer> map = new HashMap<>();

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p = pHead;
        while (p != null) {
            map.put(p,map.getOrDefault(p,0) + 1);
            if (map.get(p) == 2) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}