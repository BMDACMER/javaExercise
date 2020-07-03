package lintcode.stock;


import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/3 22:34
 *
 * 394. 字符串解码
 *
 * 两个栈：一个栈用于存放重复次数，一个栈用于存放待重复的字符。
 * eg: a3[bc]  ====>  abcbcbc
 */
public class StringDecoder {
    public String decodeString(String s) {
        Stack<Integer> nStack = new Stack<>();
        Stack<String> sStack = new Stack<>();
        int num = 0;
        String cur = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (Character.isLetter(ch)) {
                cur += ch;
            } else if (ch == '[') {
                nStack.push(num);
                sStack.push(cur);
                num = 0;
                cur = "";
            } else if (ch == ']') {
                int times = nStack.pop();
                cur = helper(times, cur);
                cur = sStack.pop() + cur;
            }
        }
        return cur;
    }

    public String helper(int times, String cur) {
        if (times < 1) return "";
        String tmp = cur;
        for (int i = 1; i < times; i++) {
            cur += tmp;
        }
        return cur;
    }
}
