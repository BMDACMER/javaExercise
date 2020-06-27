package lintcode.offer;
/// 23. �����л�����ڽ��
import java.util.HashMap;

public class Test43 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashMap<ListNode, Integer> map = new HashMap<>();
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
