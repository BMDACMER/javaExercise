package lintcode.offer;

import java.util.ArrayList;
import java.util.Stack;

public class Test21 {
    public ArrayList<Integer> printListFromTailToHead(Test04.ListNode listNode) {
        // 处理异常情况
        if (listNode == null)
            return null;

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
