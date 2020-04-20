import java.util.HashMap;

/**
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
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