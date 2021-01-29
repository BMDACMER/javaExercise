package guohaoAlgorithm.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/29 11:47
 *
 * 23. �ϲ�K����������
 * ����һ���������飬ÿ�������Ѿ����������С�
 *
 * ���㽫��������ϲ���һ�����������У����غϲ��������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺lists = [[1,4,5],[1,3,4],[2,6]]
 * �����[1,1,2,3,4,4,5,6]
 * ���ͣ������������£�
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * �����Ǻϲ���һ�����������еõ���
 * 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    // �Ǳ�����ⷨ
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> arr = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                arr.add(list);
                list = list.next;
            }
        }

        Collections.sort(arr, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < arr.size(); i++) {
            cur.next = new ListNode(arr.get(i).val);
            cur = cur.next;
        }
        return head.next;
    }

    // ���ȶ���
    // �ο���https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/leetcode-23-he-bing-kge-pai-xu-lian-biao-by-powcai/
    // ������ΪK����С�����ȶ��У��������ͷ��㶼�Ž�ȥ��Ȼ����ӵ�ǰ���ȶ�������С�ģ���������
    // ��Ȼ���ó��ӵ��Ǹ��ڵ����һ����ӣ�    // �ٳ��ӵ�ǰ���ȶ�������С�ģ�ֱ�����ȶ���Ϊ�ա�
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.offer(p.next);
        }
        return dummy.next;
    }


}
