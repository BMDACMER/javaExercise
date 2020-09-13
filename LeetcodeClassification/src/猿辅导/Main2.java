package Գ����;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/12 20:08
 * 2 СԳ���������ʽ
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            String[] s = sc.next().trim().split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                sb.append(s[i]);
            }
            int res = 0;
            if (isValid(sb.toString())) {
                // ���ؽ��
                res = (result(sb.toString()) % 10000000 + 10000000) % 10000000;
                System.out.println(res);
            } else {
                System.out.println("invalid");
            }
        }



    }

    // �Ϸ����߼�����
    private static int result(String toString) {

        return 0;
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Set<Character> set = new HashSet<Character>();
        for (Character c:s.toCharArray()) {
            if (c == '(') {
                set.add(')');
            } else if (c == ')') {
                set.remove('(');
            } else if (c == '+') {
//                set.add('')
            }
        }

        if (set.contains('(') || set.contains(')')) {
            return false;
        }

        return set.isEmpty();
    }
}
