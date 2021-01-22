package guohaoAlgorithm.greedy;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/22 17:04
 */
public class MaximumGain {

    // 采用栈  参考讨论区讲解

    /**
     * 1、贪心就是x,y值哪个更大就先统计哪个;
     *
     * 2、比如x更大，维护一个栈，当栈顶元素与当前数组元素组成“ab”时，出栈栈顶元素，sum=sum+x；
     *
     * 3、第2步遍历完后，字符串是没有“ab”了，此时再统计"ba"
     *
     * 4、第3步后，即统计完所有“ab”，“ba”, sum值最大；
     *
     * 反之y > x也同理。
     * @param s
     * @param x
     * @param y
     * @return
     */
    public int maximumGain(String s, int x, int y) {
        if (s == null || "".equals(s)) return 0;

        int ans = 0;
        // x 和 y 谁的权重大 就优先谁的
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
