package 华为;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/9 19:09
 * 1 完美队列
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            int[] a = new int[k];
            int[] b = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < k; i++) {
                b[i] = sc.nextInt();
            }

            int n = sc.nextInt();
            int[] c = new int[n];
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt();
            }

            int res = help(k, a, b, n, c, d);
            System.out.println(res);
        }
    }

    /**
     * 业务逻辑处理
     * @param k
     * @param a
     * @param b
     * @param n
     * @param c
     * @param d
     * @return
     */
    private static int help(int k, int[] a, int[] b, int n, int[] c, int[] d) {

        int i = 0, count = k, index = 0, res = 0;
        boolean flag = false;
        while (i < k) {
            // 缺少连续的判断
            for (int j = index; j < n; j++) {
                if (a[i] == c[j] && b[i] == d[j]) {
                    count--;
                    index = j + 1;
                    flag = true;   // 标记起始位置
                    break;
                }
                if (flag) {
                    res = 1;  // 是否连续
                    break;
                }
            }
            if (res == 1)
               break;
            i++;
        }

        if (count == 0 && res == 0)
            return index - k + 1;
        else
            return 0;
    }
}
