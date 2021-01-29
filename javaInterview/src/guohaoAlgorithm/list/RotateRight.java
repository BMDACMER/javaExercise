package guohaoAlgorithm.list;

import java.util.ArrayList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 14:21
 *
 * 61. ��ת����
 * ����һ��������ת����������ÿ���ڵ������ƶ� k ��λ�ã����� k �ǷǸ�����
 *
 * ʾ�� 1:
 *
 * ����: 1->2->3->4->5->NULL, k = 2
 * ���: 4->5->1->2->3->NULL
 * ����:
 * ������ת 1 ��: 5->1->2->3->4->NULL
 * ������ת 2 ��: 4->5->1->2->3->NULL
 */
public class RotateRight {

    // �����㷨
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ArrayList<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }

        int n = arr.size();
        k %= n;
        ListNode[] res = new ListNode[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr.get((i + n - k) % n);
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(res[i].val);
            cur = cur.next;
        }
        return dummy.next;
    }

}
