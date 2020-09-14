package �ֽ�����;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/14 20:41
 * �ڶ��⣺����û�뵽֮ץ������˳
 */
public class ��ϰ��2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // ����һ�������㷨
//            int res = method1(n,d,arr);

            // ���������Ľ��ı����㷨
//            Long res = method2(n, d, arr);

            // �������� �ο�ţ�� https://www.nowcoder.com/questionTerminal/c0803540c94848baac03096745b55b9b
            long res = method3(n,d,arr);

            System.out.println(res);

        }
    }

    private static long method3(int n, int d, int[] arr) {
        long res = 0;
        int left = 0, right = 2;
        while (right < n) {
            if (arr[right] - arr[left] > d) left++;
            else if (right - left < 2) right++;
            else if (arr[right] - arr[left] <= d) {
                res += Cn2(right - left);
                right++;
            }
        }

        return res % 99997867;
    }

    // �Ľ��ı����㷨  ʱ�临�Ӷ�ΪO(n^2)
    private static Long method2(int n, int d, int[] arr) {
        Long res = 0L;
        int lastj = 2;
        for (int i = 0; i < n - 2; i++) {
            int j;
            for ( j = lastj; j < n; j++) {
                if (arr[j] - arr[i] <= d)
                    res += Cn2(j - i);
                else {
                    break;
                }
            }
            lastj = j;
        }
        return res % 99997867;
    }

    private static int Cn2(int n) {
        return n * (n-1) / 2;
    }


    /**
     * �����㷨��ʱ�临�Ӷ�ΪO(n^3)
     * @param n
     * @param d
     * @param arr
     * @return
     */
    private static Long method1(int n, int d, int[] arr) {
        if (n < 3) return 0L;
        Long res = 0L;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[k] - arr[i] <= d) {
                        res++;
                    }
                }
            }
        }
        return res % 99997867;
    }
}
