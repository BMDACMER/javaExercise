package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 13:29
 *
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        /**
         * headA :  代表我生命的起点
         * headB ： 代表你生命的起点
         * 以下程序传达的咱们相遇相爱携手伴老的故事。
         *
         * 生命之初，我们未能相遇，时间流逝，让我们渐渐长大；
         * 若是有缘，终将相遇。当我走到终点时，开始走你走过的路；当你走到终点时，开始走我走过的路；
         * 如果喜欢彼此，就让咱们故事抒写下去【时而你挽着我的手，时而我搂着你的腰，渐渐的你融入了我，我也变成了你，直到尽头】
         */
        ListNode me = headA, you = headB;
        while (me != you) {  // 若是有缘终将相遇
            System.out.println(me == null ? null : me.val + "->" );
            me = me != null ? me.next : headB; //当我走到终点时，开始走你走的路；
            you = you != null ? you.next : headA; // 当你走到终点时，开始走我走的路；
        }

        // 如果喜欢彼此，就让咱们把故事进行下去
        while (you != null) {  // 直到尽头
            you = me.next;  // 时而你挽着我的手
            me = you.next;  // 时而我搂着你的腰
        }

        return me;
    }

    public static void main(String[] args) {
        GetIntersectionNode g = new GetIntersectionNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(23);
        ListNode node5 = new ListNode(24);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(23);
        ListNode n4 = new ListNode(24);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        g.getIntersectionNode(node1, n1);
    }
}
