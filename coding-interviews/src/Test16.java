/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */
public class Test16 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // ����һ�� �ǵݹ�
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

        // ��list2 ������ list3��
        if (list1 == null) {
            current.next = list2;
        }

        // ��list1������ list3��
        if (list2 == null) {
            current.next = list1;
        }

        return list3;
    }

    // ��������  �ݹ�
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
        ListNode tail = head;  // β�巨   �࿪��һ��ָ��
        for (int i = 2; i < 5; i++) {
            ListNode x = new ListNode(i + 3);
            x.next = null;
            tail.next = x;
            tail = x;
        }
        ListNode head2 = new ListNode(3);
        ListNode tail2 = head2;  // β�巨   �࿪��һ��ָ��
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
