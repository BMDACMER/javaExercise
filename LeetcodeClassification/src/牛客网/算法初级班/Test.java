package Å£¿ÍÍø.Ëã·¨³õ¼¶°à;

import java.util.Scanner;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/18 21:02
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            double m = max3(a,b,c) / (max3(a, b + c, c) + max3(a, b, b + c));
            System.out.printf("%.2f",m);
        }
    }

    private static double max3(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c? b : c);
    }
}
