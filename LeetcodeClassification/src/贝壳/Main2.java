package ����;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/7 15:40
 */
public class Main2 {


    // ��ȡ����ظ��ַ���
    public static String getMaxString(String s) {
        String reg, left;
        for (int len = s.length() / 2; len > 0; len--) {
            for (int i = 0; i < s.length() / len; i++) {
                reg = s.substring(0, len + 1);
                left = s.substring(len + 1);
                if (left.indexOf(reg) != -1) {
                    return reg;
                }
            }
        }

        return "";
    }

    // ������Ĵ���ʣ�µ�ȫ��ͳ��ʣ��Ԫ�ظ�������
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            String s = sc.next();
            String substring = s.substring(0, n); // [0,6)
            String temp = getMaxString(substring);
            if (temp.length() == 0) {
                System.out.println(n);
            } else {
                System.out.println(n - temp.length() + 1);
            }
        }
    }
}
