package ����;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/13 10:30
 * 1��ס�Ƶ�
 * ���ٴ���
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = s1.length;
        int[] arr = new int[s1.length - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        int money = Integer.parseInt(s1[n - 1]);
        // ���Ƶ�ļ۸�����
        Arrays.sort(arr);
        int res = 0;  // ��ס������

        for (int i = arr.length - 1; money > 0 && i >= 0; --i) {
            res += money / arr[i];
            money %= arr[i];
        }

        if (money == 0) {
            System.out.println(res);
        } else {
            System.out.println("-1");
        }

    }
}
