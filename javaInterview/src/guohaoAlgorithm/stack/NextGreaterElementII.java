package guohaoAlgorithm.stack;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 19:54
 *
 * 503. ��һ������Ԫ�� II
 * ����һ��ѭ�����飨���һ��Ԫ�ص���һ��Ԫ��������ĵ�һ��Ԫ�أ������ÿ��Ԫ�ص���һ������Ԫ�ء����� x ����һ�������Ԫ���ǰ��������˳���������֮��ĵ�һ�������������������ζ����Ӧ��ѭ��������������һ�������������������ڣ������ -1��
 *
 * ʾ�� 1:
 *
 * ����: [1,2,1]
 * ���: [2,-1,2]
 * ����: ��һ�� 1 ����һ����������� 2��
 * ���� 2 �Ҳ�����һ�����������
 * �ڶ��� 1 ����һ����������Ҫѭ�����������Ҳ�� 2��
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek(); // ��ǰԪ�����ĵ�һ���߸�
            stack.push(nums[i % n]);  // ���ӣ�����֮�������ж�
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementII n = new NextGreaterElementII();
        int[] nums = {1,2,1};
        int[] ints = n.nextGreaterElements(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
