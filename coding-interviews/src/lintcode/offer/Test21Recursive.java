package lintcode.offer;

import java.util.ArrayList;

public class Test21Recursive {
    public ArrayList<Integer> printListFromTailToHead(Test04.ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            list.addAll(printListFromTailToHead(listNode.next));
            list.add(listNode.val);
        }
        return list;
    }
}
