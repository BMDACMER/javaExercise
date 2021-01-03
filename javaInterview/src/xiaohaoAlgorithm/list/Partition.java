package xiaohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/3 9:07
 *
 * 86. �ָ�����
 */
public class Partition {

    /**
     * ˼·��
     *  1����С��x��ֵ��ԭ������ֱ���޸�ָ�룬�ô�ͷ�ڵ��listLeft������
     *  2�������ڵ���x��ֵ���ڴ�ͷ�ڵ��listRight������
     *  3����listRight����ϲ���listLeft�м���
     *  4������listLeft.next���ɣ���ΪlistLeftָ�����ͷ���ģ��践����һ�ڵ㣩
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode listLeft = new ListNode(-1), left = listLeft;  // ��ͷ�ڵ�� С��xֵ�����֧
        ListNode listRight = new ListNode(-1), right = listRight;  // ��ͷ�ڵ�� ���ڵ���xֵ���ҷ�֧

        while (head != null) {
            if (head.val >= x) {
                // ����õ�������һ����֧
                right.next = new ListNode(head.val);
                right = right.next;
            } else {
                // ����ֻ��Ҫ��ԭ�����и���ָ�뼴��
                left.next = head;
                left = left.next;
            }
            head = head.next;
        }

        // ��listRight�ϲ���listLeft��
        while (listRight.next != null) {
            left.next = listRight.next;
            left = left.next;
            listRight = listRight.next;
        }

        return listLeft.next;
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;*/

        ListNode node1 = new ListNode(1);

        Partition p = new Partition();
        ListNode result = p.partition(node1, 0);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
