package xiaohaoAlgorithm.stack;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/22 19:34
 * 496. ��һ������Ԫ�� I
 */
public class NextGreaterElement {

    // �ο�P267

    /**
     * 1) �ȱ���������nums2�����Ƚ���һ��Ԫ����ջ��
     * 2) ��������������ǰԪ��С��ջ��Ԫ��ʱ������������ջ������ǰԪ�ش���ջ��Ԫ��ʱ��ջ��Ԫ�س�ջ��
     * ��ʱӦ���ó�ջ��Ԫ���뵱ǰԪ���γ�key-value��ֵ�ԣ�����HashMap�У�
     * 3) ��������nums2�󣬵õ�nums2��Ԫ������Ӧ����һ������Ԫ�ص�hash��
     * 4) ����nums1��Ԫ����hashMap��ȥ���ҡ���һ������Ԫ�ء������Ҳ���ʱ��Ϊ-1��
     * @param nums1
     * @param nums2
     * @return  https://leetcode-cn.com/problems/next-greater-element-i/comments/
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement t = new NextGreaterElement();
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};

        int[] res = t.nextGreaterElement(num1, num2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
