package xiaohaoAlgorithm.list;


/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/12 13:30
 * 2. 两数相加
 */
public class TwoNumbersSum {
    public ListNode addTwoNumbersSum(ListNode l1, ListNode l2) {
        int temp = 0;  // 用来存储两数之和，并%10
        ListNode list = new ListNode(0);
        ListNode res = list;
        while (l1 != null || l2 != null || temp != 0) {
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            list.next = new ListNode(temp % 10);
            list = list.next;
            temp /= 10;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode t1 = l1;
        t1.next = new ListNode(4);
        t1 = t1.next;
        t1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode t2 = l2;
        t2.next = new ListNode(6);
        t2 = t2.next;
        t2.next = new ListNode(4);
        TwoNumbersSum twoNumbersSum = new TwoNumbersSum();
        ListNode res = twoNumbersSum.addTwoNumbersSum(l1, l2);
        printListNode(res);
    }

    private static void printListNode(ListNode res) {
        while (res != null) {
            System.out.println(res.val + " --> ");
            res = res.next;
        }
    }
}
