package �ٶ�;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/3 19:46
 *
 * ��һ�� ��λ
 * ҪôΪ0 ҪôΪ 5
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            // ����
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] res = new int[n];
            int count = 0;  // ͳ��5�ĸ���
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 5)
                    count++;
            }

            int countZero = n - count;
            // ��9�ı���
            if (count % 9 == 0) {
                // ���ٵ���һ��0 ��֤ ����90   ��5ȫ���Ƶ����
                if (count < n) {
                    int i;
                    for (i = 0; i < count; i++) {
                        res[i] = 5;
                    }

                    print(res, i, countZero);
                } else {
                    System.out.println("-1");
                }
            } else {
                // �ҳ���count�����9�ı���
                int flag = 0;  // ��� û�ҵ�
                for (int i = count - 1; i >= 9; --i) {
                    if (i % 9 == 0) {
                        int j = 0;
                        for (; j < i; j++) {
                            res[j] = 5;
                        }

                        print(res, j, countZero);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    System.out.println("-1");
            }

        }
    }

    private static void print(int[] res, int count,int countZero) {
        for (int i = 0; i < count; i++) {
            System.out.print(res[i]);
        }
        for (int i = 0; i < countZero; i++) {
            System.out.print("0");
        }
    }

}
