package xiaohaoAlgorithm.��ָoffer;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/27 11:09
 */
public class ReverseList {

    // �ǵݹ�
    public int[] reversePrint(ListNode head) {
        ListNode curr = head, prev = null;
        ListNode tmp;
        int n = 0;  // ͳ�ƽڵ���
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            n++;
        }

        // ����prev�������β�˽ڵ�
        int[] nums = new int[n];
        int index = 0;
        while (prev != null) {
            nums[index++] = prev.val;
            prev = prev.next;
        }
        return nums;
    }

    // �ǵݹ�  ����ջ
    public int[] reversePrint2(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = 0;
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
            n++;
        }

        int[] nums = new int[n];
        int index = 0;
        while (!stack.isEmpty()) {
            nums[index++] = stack.pollLast();
        }

        return nums;
    }

    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        int[] ints = r.reversePrint2(head);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
