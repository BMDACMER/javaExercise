package guohaoAlgorithm.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/28 19:44
 * <p>
 * 496. ��һ������Ԫ�� I
 * �������� û���ظ�Ԫ�� ������ nums1 �� nums2 ������nums1 �� nums2 ���Ӽ���
 * <p>
 * �����ҳ� nums1 ��ÿ��Ԫ���� nums2 �е���һ��������ֵ��
 * <p>
 * nums1 ������ x ����һ������Ԫ����ָ x �� nums2 �ж�Ӧλ�õ��ұߵĵ�һ���� x ���Ԫ�ء���������ڣ���Ӧλ����� -1 ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * ���: [-1,3,-1]
 * ����:
 * ���� num1 �е����� 4 �����޷��ڵڶ����������ҵ���һ����������֣������� -1 ��
 * ���� num1 �е����� 1 ���ڶ�������������1�ұߵ���һ���ϴ������� 3 ��
 * ���� num1 �е����� 2 ���ڶ���������û����һ����������֣������� -1 ��
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        HashMap<Integer, Integer> map = nextGreaterElementHelper(nums2);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    private HashMap<Integer, Integer> nextGreaterElementHelper(int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        return map;
    }

    /**
     * �ο� P267
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElementModule(int[] nums) {
        int[] ans = new int[nums.length];   // ��Ŵ�
        Stack<Integer> stack = new Stack<>();
        // �Ӻ���ǰ����
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(ans[i]);
        }
        return ans;
    }
}
