package lintcode.offer;

/**
 * 合并两个排序的链表：归并排序
 */
public class Test45 {
    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1 == null && list2==null)
            return null;

        ListNode list3 = new ListNode(0);
        ListNode p = list3;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

      if (list1!=null)
          p.next = list1;

     if (list2!=null)
         p.next = list2;

        return list3.next;
    }
}
