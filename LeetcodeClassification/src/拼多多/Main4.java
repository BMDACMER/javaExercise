package ƴ���;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 19:35
 * 4 ������������III
 *
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int m = scan.nextInt();

            int count = 0;
            HashSet<Integer> set = new HashSet<>();
            int[] arr = new int[m];   // �������m����

            for (int i = 0; i < m; i++) {
                arr[i] = scan.nextInt();
            }

            // m�������������
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!set.contains(j+1) && (j + 1) % arr[i] == 0) {
                        count++;
                        set.add(j+1);
                    }
                }
            }

            System.out.println(count);

        }

    }
}
