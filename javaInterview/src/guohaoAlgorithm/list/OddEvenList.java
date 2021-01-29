package guohaoAlgorithm.list;

import guohaoAlgorithm.tree.Tree;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 15:24
 *
 * 328. ��ż����
 * ����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
 *
 * �볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������
 *
 * ʾ�� 1:
 *
 * ����: 1->2->3->4->5->NULL
 * ���: 1->3->5->2->4->NULL
 *
 * ʾ�� 2:
 *
 * ����: 2->1->3->5->6->4->7->NULL
 * ���: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenList {

    // �Լ�����   һ��� ����40����   ��
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        // ��������ĳ�������Ϊ2
        ListNode second = head.next;
        ListNode headFirst = head, headSecond = second;
        boolean flag = true;
        while (headFirst.next != null && headSecond.next != null) {
            if (flag) {
                headFirst.next = headFirst.next.next;
                headFirst = headFirst.next;
                flag = false;
            }else {
                headSecond.next = headSecond.next.next;
                headSecond = headSecond.next;
                flag = true;
            }
        }
        headFirst.next = second;
        headSecond.next = null;

        return head;
    }
}
