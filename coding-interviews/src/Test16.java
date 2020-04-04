/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Test16 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 方法一： 非递归
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode list3 = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (list3 == null) {
                    list3 = current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (list3 == null) {
                    list3 = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }

        // 将list2 拷贝到 list3中
        if (list1 == null) {
            current.next = list2;
        }

        // 将list1拷贝到 list3中
        if (list2 == null) {
            current.next = list1;
        }

        return list3;
    }

    // 方法二：  递归
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge2(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;  // 尾插法   多开辟一个指针
        for (int i = 2; i < 5; i++) {
            ListNode x = new ListNode(i + 3);
            x.next = null;
            tail.next = x;
            tail = x;
        }
        ListNode head2 = new ListNode(3);
        ListNode tail2 = head2;  // 尾插法   多开辟一个指针
        for (int i = 2; i < 8; i++) {
            ListNode x = new ListNode(i + 1);
            x.next = null;
            tail2.next = x;
            tail2 = x;
        }

//        ListNode head3 = Merge(head, head2);
        ListNode head3 = Merge2(head, head2);

        while (head3 != null) {
            System.out.print(head3.val + " ");
            head3 = head3.next;
        }
    }
}
