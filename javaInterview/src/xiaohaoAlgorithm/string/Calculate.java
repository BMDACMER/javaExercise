package xiaohaoAlgorithm.string;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 8:52
 * 面试题 16.26. 计算器
 */
public class Calculate {
    /**
     * 实现加减乘除运算
     * @param
     * @return
     */
    /*public int calculate(String s) {
        int n = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (isDigital(c)) {
                n = n * 10 + (c - '0');
            }
            // 如果不是数字，可是就是字符+/-*之类的
            if ((!isDigital(c) && c != ' ') || i == len - 1) {
                int pre = 0;
                switch (sign){
                    case '+': stack.push(n); break;
                    case '-': stack.push(-n);break;
                    case '*': pre = stack.pop(); stack.push(pre * n);break;
                    case '/': pre = stack.pop(); stack.push(pre / n); break;
                }
                // 更新当前符合为当前符号，数字清零
                sign = c;
                n = 0;
            }
        }

        // 将栈中的所有结果求和就是答案
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;

    }*/

    private boolean isDigital(char c) {
        if (c >= '0' && c <= '9') return true;
        else return false;
    }


    public int calculate(String s) {
        return core(s.trim(),0);
    }

    int i;
    private int core(String s, int index) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for (i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            // 遇到左括号 开始递归 num
            if (c == '(') {
                i++;
                num = core(s, i);
            }
            if (isDigital(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!isDigital(c) && c != ' ') || i == s.length() - 1) {
                switch (sign){
                    case '+': stack.push(num);break;
                    case '-': stack.push(-num);break;
                    case '*': int a = stack.pop(); stack.push(a * num);break;
                    case '/': int b = stack.pop(); stack.push(b / num); break;
                }
                // 将num还原和sign设置为当前符号
                num = 0;
                sign = c;
            }
            // 遇到右括号 返回结果
            if (c == ')') return sum(stack);
        }

        // 将栈中所有结果求和就是答案
        return sum(stack);
    }

    private int sum(Stack<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }



    public static void main(String[] args) {
        Calculate c = new Calculate();
        System.out.println(c.calculate("-1-(12+3) * 2"));
    }
}
