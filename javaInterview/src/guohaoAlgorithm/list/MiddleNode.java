package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/2/2 18:02
 *
 * 876. ������м���   easy�Ѷ�
 * ����һ��ͷ���Ϊ head �ķǿյ���������������м��㡣
 *
 * ����������м��㣬�򷵻صڶ����м��㡣
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺[1,2,3,4,5]
 * ��������б��еĽ�� 3 (���л���ʽ��[3,4,5])
 * ���صĽ��ֵΪ 3 �� (����ϵͳ�Ըý�����л������� [3,4,5])��
 * ע�⣬���Ƿ�����һ�� ListNode ���͵Ķ��� ans��������
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, �Լ� ans.next.next.next = NULL.
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
