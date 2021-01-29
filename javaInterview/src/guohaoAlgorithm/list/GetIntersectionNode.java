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
}
