package ƴ���;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 13:58
 *
 * �Ѿ��������飬��������������0��������ɣ��ҳ�������ʹ�ó˻����
 */
public class ���������� {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();   // �����Ԫ�س���
        if (n <= 2)
            System.out.println("0");
        else {
            int max = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            // �㷨�ؼ���   �ҳ��ź���ĺ���λ ���� λ������λ�����һλ�ĳ˻�
            int a = arr[n-3] * arr[n-2] * arr[n-1];
            int b = arr[0] * arr[1] * arr[n-1];
            max = a > b ? a : b;
            System.out.println(max);
        }


    }
}
