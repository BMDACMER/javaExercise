package ƴ���;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/1 20:10
 * 2 ���ı�������
 *
 * N --- ��Ʒ������
 * M --- ������ԭʼ��С
 *
 * ci -- ��i����Ʒռ�õı����ռ�
 * vi -- ��i����Ʒ������
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[][] nums = new int[n][2];
            int res = 0;
            int sum;

            for (int i = 0; i < n; i++) {
                nums[i][0] = scan.nextInt();
                nums[i][1] = scan.nextInt();

                // ռ�ռ�������� ֱ��pass
                if (nums[i][0] > 0 && nums[i][1] < 0);
            }

        }
    }
}
