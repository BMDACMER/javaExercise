package guohaoAlgorithm.greedy;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 17:04
 */
public class MaximumGain {

    // ����ջ  �ο�����������

    /**
     * 1��̰�ľ���x,yֵ�ĸ��������ͳ���ĸ�;
     *
     * 2������x����ά��һ��ջ����ջ��Ԫ���뵱ǰ����Ԫ����ɡ�ab��ʱ����ջջ��Ԫ�أ�sum=sum+x��
     *
     * 3����2����������ַ�����û�С�ab���ˣ���ʱ��ͳ��"ba"
     *
     * 4����3���󣬼�ͳ�������С�ab������ba��, sumֵ���
     *
     * ��֮y > xҲͬ��
     * @param s
     * @param x
     * @param y
     * @return
     */
    public int maximumGain(String s, int x, int y) {
        if (s == null || "".equals(s)) return 0;

        int ans = 0;
        // x �� y ˭��Ȩ�ش� ������˭��
        if (x > y) {
            LastStr str = deleteChars(s, 'a', 'b', x);
            ans += str.sum;
            LastStr str2 = deleteChars(str.lastS, 'b', 'a', y);
            ans += str2.sum;
        } else {
            LastStr str = deleteChars(s, 'b', 'a', y);
            ans += str.sum;
            LastStr str2 = deleteChars(str.lastS, 'a', 'b', x);
            ans += str2.sum;
        }
        return ans;
    }

    private LastStr deleteChars(String s, char first, char second, int weight) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        LastStr lastStr = new LastStr(0,s);
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else if (stack.peek() == first && chars[i] == second) {
                lastStr.sum += weight;
                stack.pop();
            }else {
                stack.push(chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        lastStr.lastS = sb.reverse().toString();
        return lastStr;

    }

    public static class LastStr{
        int sum;
        String lastS;
        public LastStr(int sum, String lastS) {
            this.sum = sum;
            this.lastS = lastS;
        }
    }
}
