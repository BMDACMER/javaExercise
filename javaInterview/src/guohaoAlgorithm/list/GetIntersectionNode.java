package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 13:29
 *
 * 160. �ཻ����
 * ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        /**
         * headA :  ���������������
         * headB �� ���������������
         * ���³��򴫴�����������మЯ�ְ��ϵĹ��¡�
         *
         * ����֮��������δ��������ʱ�����ţ������ǽ�������
         * ������Ե���ս������������ߵ��յ�ʱ����ʼ�����߹���·�������ߵ��յ�ʱ����ʼ�����߹���·��
         * ���ϲ���˴ˣ��������ǹ�����д��ȥ��ʱ���������ҵ��֣�ʱ����§������������������������ң���Ҳ������㣬ֱ����ͷ��
         */
        ListNode me = headA, you = headB;
        while (me != you) {  // ������Ե�ս�����
            System.out.println(me == null ? null : me.val + "->" );
            me = me != null ? me.next : headB; //�����ߵ��յ�ʱ����ʼ�����ߵ�·��
            you = you != null ? you.next : headA; // �����ߵ��յ�ʱ����ʼ�����ߵ�·��
        }

        // ���ϲ���˴ˣ��������ǰѹ��½�����ȥ
        while (you != null) {  // ֱ����ͷ
            you = me.next;  // ʱ���������ҵ���
            me = you.next;  // ʱ����§�������
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
