package Գ����;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/12 19:36
 * 1��СԳ���˿���ħ��
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // �����㷨
            help(arr, N, M);
        }
    }

    private static void help(int[] arr, int n, int m) {
        // ��������
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            return;
        }

        // arr.lengthһ��Ϊż��  ������2
        int[] left = new int[n/2];
        int[] right = new int[n/2];
        for (int i = 0; i < n/2; i++) {
            left[i] = arr[i];
        }
        int j = 0;
        for (int i = n/2; i < n; i++) {
            right[j++] = arr[i];
        }

        int index = 0;
        for (int i = 0; i < n/2; i++) {
            arr[index] = right[i];
            index++;
            arr[index] = left[i];
            index++;
        }

        help(arr, n, m - 1);

    }
}
