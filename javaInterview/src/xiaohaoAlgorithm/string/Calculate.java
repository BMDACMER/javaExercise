package xiaohaoAlgorithm.string;

import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/4 8:52
 * ������ 16.26. ������
 */
public class Calculate {
    /**
     * ʵ�ּӼ��˳�����
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
            // ����������֣����Ǿ����ַ�+/-*֮���
            if ((!isDigital(c) && c != ' ') || i == len - 1) {
                int pre = 0;
                switch (sign){
                    case '+': stack.push(n); break;
                    case '-': stack.push(-n);break;
                    case '*': pre = stack.pop(); stack.push(pre * n);break;
                    case '/': pre = stack.pop(); stack.push(pre / n); break;
                }
                // ���µ�ǰ����Ϊ��ǰ���ţ���������
                sign = c;
                n = 0;
            }
        }

        // ��ջ�е����н����;��Ǵ�
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
            // ���������� ��ʼ�ݹ� num
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
                // ��num��ԭ��sign����Ϊ��ǰ����
                num = 0;
                sign = c;
            }
            // ���������� ���ؽ��
            if (c == ')') return sum(stack);
        }

        // ��ջ�����н����;��Ǵ�
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
