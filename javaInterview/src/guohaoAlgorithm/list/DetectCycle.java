package guohaoAlgorithm.list;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 12:25
 *
 * 142. �������� II
 * ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��
 *
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣬pos ���������ڱ�ʶ�����������������Ϊ�������ݵ������С�
 *
 * ˵�����������޸ĸ���������
 *
 * ���ף�
 *
 * ���Ƿ����ʹ�� O(1) �ռ������⣿
 *
 */
public class DetectCycle {
    // �����ж��Ƿ��л��������򷵻���ʼλ��  ���򷵻�-1
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
