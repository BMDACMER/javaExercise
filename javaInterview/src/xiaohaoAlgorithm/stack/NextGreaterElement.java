package xiaohaoAlgorithm.stack;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/12/22 19:34
 * 496. 下一个更大元素 I
 */
public class NextGreaterElement {

    // 参考P267

    /**
     * 1) 先遍历大数组nums2，首先将第一个元素入栈；
     * 2) 继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，
     * 此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
     * 3) 当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
     * 4) 遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
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
