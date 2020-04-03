import java.util.*;


public class Test03 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 使用栈  后进先出----> 逆序
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 进栈
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        // 出栈
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;  // 尾插法   多开辟一个指针
        for (int i = 2; i < 11; i++) {
            ListNode x = new ListNode(i);
            x.next = null;
            tail.next = x;
            tail = x;
        }

        System.out.println(printListFromTailToHead(head));
    }
}
